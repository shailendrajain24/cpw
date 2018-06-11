package com.cpw.dao;

import java.util.List;

import javax.sql.DataSource;

import com.cpw.jdbc.model.PendingInvoicesDetail;

public interface PendingInvoiceDetailDAO {

	public void setDataSource(DataSource ds);

	public List<PendingInvoicesDetail> pendingInvoiceList(String userName);

}
