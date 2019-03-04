package com.allmsi.netmovie.model;

import java.math.BigDecimal;
import java.util.Date;

public class MovieDaily {
    private String id;

    private String movieId;

    private String movieName;

    private String dailyDate;

    private String releaseDate;

    private Short releaseDays;

    private BigDecimal dailyBox;

    private BigDecimal sumBox;

    private Byte topOrder;
    
    private String growthRate;

    private Date createdAt;
    
    private String uplift;
    
    private Integer topCount;
    
    private String startDate;
    
    private String endDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId == null ? null : movieId.trim();
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName == null ? null : movieName.trim();
    }

    public String getDailyDate() {
        return dailyDate;
    }

    public void setDailyDate(String dailyDate) {
        this.dailyDate = dailyDate == null ? null : dailyDate.trim();
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate == null ? null : releaseDate.trim();
    }

    public Short getReleaseDays() {
        return releaseDays;
    }

    public void setReleaseDays(Short releaseDays) {
        this.releaseDays = releaseDays;
    }

    public BigDecimal getDailyBox() {
        return dailyBox;
    }

    public void setDailyBox(BigDecimal dailyBox) {
        this.dailyBox = dailyBox;
    }

    public BigDecimal getSumBox() {
        return sumBox;
    }

    public void setSumBox(BigDecimal sumBox) {
        this.sumBox = sumBox;
    }

    public Byte getTopOrder() {
        return topOrder;
    }

    public void setTopOrder(Byte topOrder) {
        this.topOrder = topOrder;
    }

    public String getGrowthRate() {
		return growthRate;
	}

	public void setGrowthRate(String growthRate) {
		this.growthRate = growthRate;
	}

	public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

	public String getUplift() {
		return uplift;
	}

	public void setUplift(String uplift) {
		this.uplift = uplift;
	}

	public Integer getTopCount() {
		return topCount;
	}

	public void setTopCount(Integer topCount) {
		this.topCount = topCount;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
}