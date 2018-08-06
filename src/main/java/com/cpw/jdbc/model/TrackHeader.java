package com.cpw.jdbc.model;

import java.util.List;

import com.cpw.model.TraceResponse;
import com.cpw.model.TrackingHeaderResponse;

public class TrackHeader {
	
		private List<TraceResponse> trace;
		private TrackingHeaderResponse header;
		public TrackHeader(List<TraceResponse> trace, TrackingHeaderResponse header) {
			super();
			this.trace = trace;
			this.header = header;
		}
		public List<TraceResponse> getTrace() {
			return trace;
		}
		public void setTrace(List<TraceResponse> trace) {
			this.trace = trace;
		}
		public TrackingHeaderResponse getHeader() {
			return header;
		}
		public void setHeader(TrackingHeaderResponse header) {
			this.header = header;
		}
	
		
		
		
		
	

		
}
