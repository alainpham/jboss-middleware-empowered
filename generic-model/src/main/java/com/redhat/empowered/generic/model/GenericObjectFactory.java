package com.redhat.empowered.generic.model;

public class GenericObjectFactory {

	public StatisticsRecord createStatisticsRecord(String key) {
		StatisticsRecord statisticsRecord = new StatisticsRecord();
		statisticsRecord.setKey(key);
		return statisticsRecord;
	}
}
