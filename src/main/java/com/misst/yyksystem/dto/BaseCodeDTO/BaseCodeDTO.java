package com.misst.yyksystem.dto.BaseCodeDTO;


import com.misst.yyksystem.entity.BaseCode;

import java.util.List;


/**
 * <P>Description: TODO</P>
 * @ClassName: basCode
 * @author lijing
 * @see
 */
public class BaseCodeDTO extends BaseCode {

    private int level;
    private String after_html;
    private String parentName;
    private List<BaseCodeDTO> nodes;
    private String text;
    private String flagNode;
    private String[] tags;
    private String applyType;
    private String lineType;
    private String vehicleType;
	private String partentCode;
    
    
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
    public String getLineType() {
		return lineType;
	}
	public void setLineType(String lineType) {
		this.lineType = lineType;
	}
	private String childerCode;
    
	public String getChilderCode() {
		return childerCode;
	}
	public void setChilderCode(String childerCode) {
		this.childerCode = childerCode;
	}
	public String getPartentCode() {
		return partentCode;
	}
	public void setPartentCode(String partentCode) {
		this.partentCode = partentCode;
	}
	
	public String getApplyType() {
		return applyType;
	}
	public void setApplyType(String applyType) {
		this.applyType = applyType;
	}
	public String[] getTags() {
		return tags;
	}
	public void setTags(String[] tags) {
		this.tags = tags;
	}
	public String getFlagNode() {
		return flagNode;
	}
	public void setFlagNode(String flagNode) {
		this.flagNode = flagNode;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getAfter_html() {
		return after_html;
	}
	public void setAfter_html(String after_html) {
		this.after_html = after_html;
	}
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	public List<BaseCodeDTO> getNodes() {
		return nodes;
	}
	public void setNodes(List<BaseCodeDTO> nodes) {
		this.nodes = nodes;
	}
	
	
}