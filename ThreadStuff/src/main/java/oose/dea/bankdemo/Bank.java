package oose.dea.bankdemo;

public class Bank {
    private int saldo = 100;

    public synchronized void stort(int amount) {
        System.out.println("Saldo voor storting " + saldo + ", stort: " + amount);
        saldo = saldo + amount;
        System.out.println("Saldo na storting " + saldo);
    }

    public synchronized void neemOp(int amount) {
        System.out.println("Saldo voor opname " + saldo + ", neem op: " + amount);
        if (saldo - amount > 0) {
            // er is genoeg saldo om op te nemen
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            saldo = saldo - amount;
        } else {
            System.out.println("Onvoldoende saldo, saldo: " + saldo);
            return;
        }
        System.out.println("Saldo na opname " + saldo);
    }

    public static void main(String[] args) {
        Bank bank = new Bank();

        /*
		/* Example without Threads
		 */
        //bank.stort(50);
        //bank.neemOp(80);
        //bank.neemOp(100);

		/*
		/* Thread example
		 */
        //StortThread stort1 = new StortThread(bank, 50);
        //OpnameThread opname1 = new OpnameThread(bank, 80);
        //OpnameThread opname2 = new OpnameThread(bank, 100);
        //stort1.start();
        //opname1.start();
        //opname2.start();

		/*
		/* Thread with Lambda expression example
		 */
        Thread thread1 = new Thread(() -> bank.stort(50));
        Thread thread2 = new Thread(() -> bank.neemOp(80));
        Thread thread3 = new Thread(() -> bank.neemOp(100));
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
