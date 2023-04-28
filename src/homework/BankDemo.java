package homework;

import java.util.Scanner;

public class BankDemo {
    public static void main(String[] args) {
        Bank bank = new Bank(10000, 123456);
//        System.out.println(bank.getMoney());
//        bank.balanceInquiry();
        bank.drawMoney(14555);
        bank.saveMoney(45666);
    }
}

class Bank {
    private double money;
    private int password;

    public Bank(double money, int password) {
        this.money = money;
        this.password = password;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    private boolean getPassword() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入密码：");
        if (scanner.nextInt() == this.password) {
            return true;
        } else {
            System.out.println("密码错误！");
            return false;
        }
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public double saveMoney(double deposit) {
        boolean passwordCofirm = getPassword();
        if (passwordCofirm == true) {
            System.out.println("存款成功，余额为：" + (this.money + deposit));
            return this.money + deposit;
        } else {
            return -1;
        }
    }

    public double drawMoney(double withdrawal) {
        boolean passwordCofirm = getPassword();
        if (passwordCofirm == true) {
            if (withdrawal > this.money) {
                System.out.println("余额不足，无法取款！");
                return -1;
            }
            System.out.println("取款成功，余额为：" + (this.money - withdrawal));
            return this.money + withdrawal;
        } else {
            return -1;
        }
    }

    public double balanceInquiry() {
        boolean passwordCofirm = getPassword();
        if (passwordCofirm == true) {
            System.out.println("余额为" + this.money);
            return this.money;
        } else {
            return -1;
        }
    }

}