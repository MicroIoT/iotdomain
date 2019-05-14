package top.microiot.dto;

import org.springframework.data.geo.Metrics;

public class QueryNearPageInfo extends QueryPageInfo {
	private double x;
	private double y;
	
	private double maxDistance;
	private Metrics metrics = Metrics.NEUTRAL;
	
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getMaxDistance() {
		return maxDistance;
	}

	public void setMaxDistance(double maxDistance) {
		this.maxDistance = maxDistance;
	}

	public Metrics getMetrics() {
		return metrics;
	}

	public void setMetrics(Metrics metrics) {
		this.metrics = metrics;
	}
}
