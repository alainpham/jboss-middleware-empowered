package com.redhat.empowered.generic.model;

public class GenericObjectFactory {

	public StatisticsRecord createStatisticsRecord(String key) {
		StatisticsRecord statisticsRecord = new StatisticsRecord();
		statisticsRecord.setKey(key);
		return statisticsRecord;
	}
	
	public IndicatorRecord createIndicatorRecord(IndicatorRecord indicatorRecord){
		IndicatorRecord newIndicatorRecord = new IndicatorRecord();
		
		// mapping data
		newIndicatorRecord.setUid(indicatorRecord.getUid());
		newIndicatorRecord.setValue(indicatorRecord.getValue());
		newIndicatorRecord.setTimestmp(indicatorRecord.getTimestmp());
		newIndicatorRecord.setFrequencyGroupValue(indicatorRecord.getFrequencyGroupValue());
		newIndicatorRecord.setIndicatorClass(indicatorRecord.getIndicatorClass());
		
		return newIndicatorRecord;
		
	}
}
