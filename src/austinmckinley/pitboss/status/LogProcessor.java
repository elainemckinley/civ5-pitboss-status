package austinmckinley.pitboss.status;

import org.springframework.scheduling.annotation.Scheduled;

import austinmckinley.pitboss.status.dataobjects.StatusRecord;

public class LogProcessor {
	private StatusParser gateway;
	private StatusRecord statusRecord = new StatusRecord();
	
	@Scheduled(fixedDelay = 300)
	private void checkAndProcessUpdates() {
		throw new UnsupportedOperationException("checkAndProcessUpdates Not implemented");
	}
	
	public void forceCheckForUpdates() {
		throw new UnsupportedOperationException("forceCheckForUpdates Not implemented");
	}
	
	public StatusRecord retrieveUpdatedStatusRecord() {
		checkAndProcessUpdates();

		return statusRecord;
	}
	
}
