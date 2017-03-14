package com.swapstech.boss.common.model;

import org.springframework.data.annotation.Id;

public class Document {
	private String sourceObjectId;
	private String documentName;
	private String directory;
	private String fileName;
	private String status;
	private String legalEntityId;
	private String createTime;
	
	
	public String getSourceObjectId() {
		return sourceObjectId;
	}
	public void setSourceObjectId(String sourceObjectId) {
		this.sourceObjectId = sourceObjectId;
	}
	public String getDocumentName() {
		return documentName;
	}
	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}
	public String getDirectory() {
		return directory;
	}
	public void setDirectory(String directory) {
		this.directory = directory;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getLegalEntityId() {
		return legalEntityId;
	}
	public void setLegalEntityId(String legalEntityId) {
		this.legalEntityId = legalEntityId;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
	
}
