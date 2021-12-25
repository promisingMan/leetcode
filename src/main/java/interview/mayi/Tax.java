package interview.mayi;

/**
 * @author zengjia
 * @date 2021-12-06 20:13:37
 */
//题目2
//实现个税的计算
//1~5000 税率 0
//5001~8000 3%
//8001~17000 10%
//17001~30000 20%
//30001~40000 25%
//40001~60000 30%
//60001~85000 35%
//85001~      45%
//要求
//1. 逻辑正确，代码优雅
//2. 可扩展性，考虑区间的变化，比如说起征点从5000变成10000等等，或者说85000以上的征税50%。
//这里举个例子，比如说税前10000元，5000部分是不扣税，后面5000，3000扣税3%，2000扣税10%。
public class Tax {
    Interval interval;

    public Tax() {
        interval = new Interval(1, 5000, 0);
        interval.append(5001, 8000, 3)
                .append(8001, 17000, 10)
                .append(17001, 30000, 20)
                .append(30001, 40000, 25)
                .append(40001, 60000, 30)
                .append(60001, 85000, 35)
                .append(85001, Double.MAX_VALUE, 45);
    }

    public static void main(String[] args) {
        Tax tax = new Tax();
        double a = tax.calculate(4000);
        double b = tax.calculate(5000);
        double c = tax.calculate(6000);
        double d = tax.calculate(90000);
        System.out.printf("%s-%s-%s-%s%n", a, b, c, d);
    }

    /**
     * 计算个税
     *
     * @param money 税前金额
     * @return 应扣税额
     */
    double calculate(double money) {
        return interval.calculate(money, 0);
    }

    public static class Interval {
        double start;
        double end;
        double rate;
        Interval next;

        public Interval(double start, double end, double rate) {
            this.start = start;
            this.end = end;
            this.rate = rate;
        }

        double calculate(double money, double tax) {
            if (money <= this.end) {
                tax += (money - this.start + 1) * this.rate / 100;
                return tax;
            } else {
                tax += (this.end - this.start + 1) * this.rate / 100;
                return this.next.calculate(money, tax);
            }
        }

        public Interval append(double start, double end, double rate) {
            Interval interval = new Interval(start, end, rate);
            this.next = interval;
            return interval;
        }
    }
}
