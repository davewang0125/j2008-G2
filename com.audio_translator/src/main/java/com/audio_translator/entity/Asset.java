package com.audio_translator.entity;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//Userid, assetType [audio, transcript, translation], assetId, content, timestamp

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "asset")
public class Asset {
	
	@Id
	@GeneratedValue
	@Column(name = "user_id")
	private Integer userId;
	
	@Column(name="audio")
	private String audio;
	
	@Column(name="transcript")
	private String transcript;
	
	@Column(name="translation")
	private String translation;
	
	@Column(name="asset_id")
	private String assetId;
	
	@Column(name="content")
	private String content;
	
	@Column(name="timetamp")
	private LocalDateTime timetamp;

	@OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
	
	public Asset(String audio, String transcript, String tranlation, String assetId, String content, LocalDateTime timetamp) {
		this.audio = audio;
		this.transcript = transcript;
		this.translation = tranlation;
		this.assetId = assetId;
		this.content = content;
		this.timetamp = LocalDateTime.now();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Asset asset = (Asset) o;
		return Objects.equals(userId, asset.userId) &&
			Objects.equals(audio, asset.audio) &&
			Objects.equals(transcript, asset.transcript) &&
			Objects.equals(translation, asset.translation) &&
			Objects.equals(assetId, asset.assetId) &&
			Objects.equals(content, asset.content) &&
			Objects.equals(timetamp, asset.timetamp);
	}

	@Override
	public int hashCode() {

		return Objects.hash(userId, audio, transcript, translation, assetId, content, timetamp);
	}

	@Override
	public String toString() {
		return "user{" +
			"id=" + userId +
			", audio='" + audio + '\'' +
			", transcript='" + transcript + '\'' +
			", translation='" + translation + '\'' +
			", assetId='" + assetId + '\'' +
			", content='" + content + '\'' +
			", timetamp='" + timetamp + '\'' +
			'}';
	}
}
