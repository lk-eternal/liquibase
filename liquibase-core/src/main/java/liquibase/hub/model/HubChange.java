package liquibase.hub.model;

import liquibase.changelog.ChangeSet;
import liquibase.changelog.RanChangeSet;
import liquibase.util.ISODateFormat;

import java.text.ParseException;
import java.util.Date;
import java.util.UUID;

public class HubChange implements HubModel {

    private UUID id;
    private String changesetId;
    private String changesetAuthor;
    private String changesetFilename;
    private String description;
    private String comments;
    private String tag;
    private String liquibase;
    private String labels;
    private String contexts;
    private Integer orderExecuted;
    private String md5sum;
    private String execType;
    private String deploymentId;
    private Date dateExecuted;

    public HubChange() {
    }

    @Override
    public UUID getId() {
        return id;
    }

    public String getChangesetId() {
        return changesetId;
    }

    public void setChangesetId(String changesetId) {
        this.changesetId = changesetId;
    }

    public String getChangesetAuthor() {
        return changesetAuthor;
    }

    public void setChangesetAuthor(String changesetAuthor) {
        this.changesetAuthor = changesetAuthor;
    }

    public String getChangesetFilename() {
        return changesetFilename;
    }

    public void setChangesetFilename(String changesetFilename) {
        this.changesetFilename = changesetFilename;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getLiquibase() {
        return liquibase;
    }

    public void setLiquibase(String liquibase) {
        this.liquibase = liquibase;
    }

    public String getLabels() {
        return labels;
    }

    public void setLabels(String labels) {
        this.labels = labels;
    }

    public String getContexts() {
        return contexts;
    }

    public void setContexts(String contexts) {
        this.contexts = contexts;
    }

    public Integer getOrderExecuted() {
        return orderExecuted;
    }

    public void setOrderExecuted(Integer orderExecuted) {
        this.orderExecuted = orderExecuted;
    }

    public String getMd5sum() {
        return md5sum;
    }

    public void setMd5sum(String md5sum) {
        this.md5sum = md5sum;
    }

    public String getExecType() {
        return execType;
    }

    public void setExecType(String execType) {
        this.execType = execType;
    }

    public String getDeploymentId() {
        return deploymentId;
    }

    public void setDeploymentId(String deploymentId) {
        this.deploymentId = deploymentId;
    }

    public Date getDateExecuted() {
        return dateExecuted;
    }

    public void setDateExecuted(Date dateExecuted) {
        this.dateExecuted = dateExecuted;
    }
}
