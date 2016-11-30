package com.redhat.empowered.tester;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.camel.EndpointInject;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.util.FileUtil;
import org.apache.commons.math3.random.GaussianRandomGenerator;
import org.apache.commons.math3.random.RandomDataGenerator;
import org.apache.commons.math3.random.RandomGenerator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.redhat.empowered.specific.model.trading.TradeProcessingDuration;

public class DataGenerator extends Thread{

	@EndpointInject(uri="activemq:queue:app.stats.trades")
	private ProducerTemplate producer;
	
	public ProducerTemplate getProducer() {
		return producer;
	}



	public void setProducer(ProducerTemplate producer) {
		this.producer = producer;
	}

	private RandomDataGenerator dataGenerator=  new RandomDataGenerator();
	

	private BigDecimal avg;
	private BigDecimal stdev;
	
    private volatile boolean running = true;

    private static DataGenerator generatorThread;
    
    public void terminate() {
    	generatorThread.running = false;
    }
	
    
    
	public boolean isRunning() {
		return running;
	}



	public void setRunning(boolean running) {
		this.running = running;
	}



	public void readData(){
		
	}
	
	public BigDecimal getAvg() {
		return avg;
	}

	public void setAvg(BigDecimal avg) {
		this.avg = avg;
	}

	public BigDecimal getStdev() {
		return stdev;
	}

	public void setStdev(BigDecimal stdev) {
		this.stdev = stdev;
	}
	
	public void startSim(String avg, String stdev){
		generatorThread = new DataGenerator();
		generatorThread.setProducer(this.producer);
		generatorThread.running = true;
		generatorThread.avg = new BigDecimal(avg);
		generatorThread.stdev = new BigDecimal(stdev);
		generatorThread.start();
	}
	
	@Override
	public void run() {
		ObjectMapper mapper = new ObjectMapper();

	       while (this.running) {
	            try {
	            	BigDecimal value = new BigDecimal(dataGenerator.nextGaussian(avg.doubleValue(), stdev.doubleValue()),MathContext.DECIMAL64);
	            	value = value.abs();
	            	TradeProcessingDuration tradeProcessingDuration = new TradeProcessingDuration();
	            	tradeProcessingDuration.setUid("" + System.currentTimeMillis());
	            	tradeProcessingDuration.setTimestmp(new Date());
	            	tradeProcessingDuration.setValue(value);
	            	producer.sendBody(mapper.writeValueAsString(tradeProcessingDuration));
	            	Thread.sleep(dataGenerator.nextLong(200, 1000));
	            } catch (Exception e) {
					e.printStackTrace();
	            }
	        }
	}

}
