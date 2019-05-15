package top.microiot.domain;

import org.bson.Document;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperationContext;

/**
 * 聚合操作类。
 *
 * @author 曹新宇
 */
public class DocumentAggregationOperation implements AggregationOperation {
	private Document document;
	public DocumentAggregationOperation(Document document) {
		super();
		this.document = document;
	}

	@Override
	public Document toDocument(AggregationOperationContext context) {
		return document;
	}

}
