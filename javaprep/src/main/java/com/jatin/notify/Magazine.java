package com.jatin.notify;

public class Magazine {
	
	String month;
	
	Integer edition;
	
	Boolean isNew = false;

	public synchronized void publishNew(int i){
		if(!this.isNew){
			
			this.setEdition(i + 1);
			this.setMonth("Edition:" + this.getEdition());
			this.setIsNew(true);
			
			System.out.println(Thread.currentThread().getName() + " Published new edition \n");	
			
			notifyAll();
		}else{
			try {
				System.out.println(Thread.currentThread().getName() + " Waiting for current edition to become old. \n");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public synchronized void recieveNew(){
		if (this.isNew) {
			System.out.println(Thread.currentThread().getName() + " Got new Edition --> " + this.getMonth());
			
			this.setIsNew(false);

			notifyAll();

		} else {
			try {

				System.out.println(Thread.currentThread().getName() + " Waiting for new edition... \n");
				wait();
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

	
	public Boolean getIsNew() {
		return isNew;
	}

	public void setIsNew(Boolean isNew) {
		this.isNew = isNew;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public Integer getEdition() {
		return edition;
	}

	public void setEdition(Integer edition) {
		this.edition = edition;
	}
	
	
}
