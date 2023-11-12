package org.example;

public class MeiMiException extends RuntimeException{
    private Double money;

    public MeiMiException(Double money) {
        super("余额不足，还差：" + money);
        this.money = money;
    }

    public static class AccountAdmin {
        private Double balance;

        public AccountAdmin(Double balance) {
            this.balance = balance;
        }

        //存钱的方法
        public void deposit(double money) {
            this.balance += money;
        }

        //取钱的方法
        public void withdraw(double money) throws MeiMiException {
            if (balance >= money) {
                balance -= money;
            } else {
                double needMoney = money - balance;
                throw new MeiMiException(needMoney);
            }
        }
    }

    public static void main(String[] args) {
        AccountAdmin accountAdmin = new AccountAdmin(100.0);
        accountAdmin.deposit(200);//先存二伯块
        try {
            //再取四伯块
            accountAdmin.withdraw(400);
        } catch (MeiMiException e) {
            throw new RuntimeException(e);
        }
    }
}
