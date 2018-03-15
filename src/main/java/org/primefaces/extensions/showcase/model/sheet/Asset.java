package org.primefaces.extensions.showcase.model.sheet;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Asset implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long assetId;

	private Date purchaseDate;

	private String hostName;

	private String description;

	private BigDecimal purchasePrice;

	private PlatformType platform;

	private PlatformArchType platformArch;

	private AssetType assetType;

	private String comment;

	private Date lastUpdated;

	private String patchLevel;

	private String allocatedTo;

	private String location;

	private Integer value1;

	private Integer value2;

	private Integer value3;

	private Integer value4;

	private Integer value5;

	private Integer value6;

	private Integer value7;

	private Integer value8;

	private Integer value9;

	private Integer value10;

	public Long getAssetId() {
		return assetId;
	}

	public void setAssetId(Long assetId) {
		this.assetId = assetId;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(BigDecimal purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public PlatformType getPlatform() {
		return platform;
	}

	public void setPlatform(PlatformType platform) {
		this.platform = platform;
	}

	public PlatformArchType getPlatformArch() {
		return platformArch;
	}

	public void setPlatformArch(PlatformArchType platformArch) {
		this.platformArch = platformArch;
	}

	public AssetType getAssetType() {
		return assetType;
	}

	public void setAssetType(AssetType assetType) {
		this.assetType = assetType;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public String getPatchLevel() {
		return patchLevel;
	}

	public void setPatchLevel(String patchLevel) {
		this.patchLevel = patchLevel;
	}

	public String getAllocatedTo() {
		return allocatedTo;
	}

	public void setAllocatedTo(String allocatedTo) {
		this.allocatedTo = allocatedTo;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getValue1() {
		return value1;
	}

	public void setValue1(Integer value1) {
		this.value1 = value1;
	}

	public Integer getValue2() {
		return value2;
	}

	public void setValue2(Integer value2) {
		this.value2 = value2;
	}

	public Integer getValue3() {
		return value3;
	}

	public void setValue3(Integer value3) {
		this.value3 = value3;
	}

	public Integer getValue4() {
		return value4;
	}

	public void setValue4(Integer value4) {
		this.value4 = value4;
	}

	public Integer getValue5() {
		return value5;
	}

	public void setValue5(Integer value5) {
		this.value5 = value5;
	}

	public Integer getValue6() {
		return value6;
	}

	public void setValue6(Integer value6) {
		this.value6 = value6;
	}

	public Integer getValue7() {
		return value7;
	}

	public void setValue7(Integer value7) {
		this.value7 = value7;
	}

	public Integer getValue8() {
		return value8;
	}

	public void setValue8(Integer value8) {
		this.value8 = value8;
	}

	public Integer getValue9() {
		return value9;
	}

	public void setValue9(Integer value9) {
		this.value9 = value9;
	}

	public Integer getValue10() {
		return value10;
	}

	public void setValue10(Integer value10) {
		this.value10 = value10;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((assetId == null) ? 0 : assetId.hashCode());
		result = prime * result + ((hostName == null) ? 0 : hostName.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Asset other = (Asset) obj;
		if (assetId == null) {
			if (other.assetId != null)
				return false;
		} else if (!assetId.equals(other.assetId))
			return false;
		if (hostName == null) {
			if (other.hostName != null)
				return false;
		} else if (!hostName.equals(other.hostName))
			return false;
		return true;
	}

	public Integer getTotal() {
		return (value1 == null ? 0 : value1) +
				(value2 == null ? 0 : value2) +
				(value3 == null ? 0 : value3) +
				(value4 == null ? 0 : value4) +
				(value5 == null ? 0 : value5) +
				(value6 == null ? 0 : value6) +
				(value7 == null ? 0 : value7) +
				(value8 == null ? 0 : value8) +
				(value9 == null ? 0 : value9) +
				(value10 == null ? 0 : value10);
	}
}
