package CompletableFuture.one;

public class App {

    public static void main(String[] args) throws InterruptedException {
//        MyThread myThread = new MyThread();
//        myThread.start();
//
//        System.out.println("Hello " + Thread.currentThread().getName());

        Thread thread = new Thread(() -> {
//            while(true) {
//                System.out.println(Thread.currentThread().getName());
//
//                try {
//                    Thread.sleep(1000L);
//                } catch (InterruptedException e) {
//                    System.out.println("Exit!");
////                    e.printStackTrace();
////                    리턴하지 않으면 계속 진행된다.
////                    return;
//                }
//
//            }
            System.out.println("Thread: " + Thread.currentThread().getName());
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
        });
        thread.start();

        System.out.println("Hello " + Thread.currentThread().getName());
//        Thread.sleep(3000L);
        thread.join();
//        thread.interrupt();
        System.out.println(thread + " is finished");
    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Thread: " + Thread.currentThread().getName());
        }
    }
}
