package interactor;

import java.util.List;

import entity.Order;
import entity.ReportCode;
import entity.RevenueReport;

public interface ReportBoundaryInterface {
	public ReportCode[] getReportType();
	public List<Order> getDeliveryToday();
	public List<Order> getDeliveryTomorrow();
	public RevenueReport getRevenueReport(String start_date,String end_date) throws RuntimeException;
	public List<Order> getDeliveryList(String start_date,String end_date) throws RuntimeException;

}
