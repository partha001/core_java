package com.partha.multithread.topic08.executors.ex05.returningValues;

public class Application02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	static interface ResultListener<T> {
		
		public void notifyResult(T result);
	}
	
	static class SumObserver implements ResultListener<Integer>{

		@Override
		public void notifyResult(Integer result) {
			
		}
		
	}

}
