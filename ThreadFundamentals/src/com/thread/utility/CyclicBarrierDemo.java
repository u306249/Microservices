package com.thread.utility;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierDemo {

	public static void main(String[] args) throws InterruptedException {
		
		ExecutorService service = Executors.newFixedThreadPool(4);
		CyclicBarrier barrier = new CyclicBarrier(3);
		
		service.submit(new DependentService(barrier));
		service.submit(new DependentService(barrier));
		service.submit(new DependentService(barrier));
				
		System.out.println("Starting the process");

	}
	static class DependentService implements Runnable{
		
		private CyclicBarrier barrier = null;
		public DependentService(CyclicBarrier barrier) {
			this.barrier = barrier;
		}
		@Override
		public void run() {
			System.out.println("Intializing the process");
			try {
				Thread.sleep(2000);
				barrier.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				e.printStackTrace();
			}
			
			System.out.println("Waiting in the cyclick barrier");
		}
	}
}
