package com.redhat.empowered.generic.processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.redhat.empowered.generic.model.IndicatorRecord;
import com.redhat.empowered.generic.model.StatisticsRecord;

public class TriggerMetricCalculation implements Processor {

	public void process(Exchange exchange) throws Exception {
		exchange.getIn().getHeader("hourly", StatisticsRecord.class).update(exchange.getIn().getBody(IndicatorRecord.class));
		exchange.getIn().getHeader("daily", StatisticsRecord.class).update(exchange.getIn().getBody(IndicatorRecord.class));;
		exchange.getIn().getHeader("monthly", StatisticsRecord.class).update(exchange.getIn().getBody(IndicatorRecord.class));;
	}

}
