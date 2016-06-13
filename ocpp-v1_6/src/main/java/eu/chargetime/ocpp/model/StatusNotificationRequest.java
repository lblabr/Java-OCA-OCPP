package eu.chargetime.ocpp.model;

import eu.chargetime.ocpp.PropertyConstraintException;
import eu.chargetime.ocpp.utilities.ModelUtil;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

/**
 * ChargeTime.eu - Java-OCA-OCPP
 *
 * MIT License
 *
 * Copyright (C) 2016 Thomas Volden <tv@chargetime.eu>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
public class StatusNotificationRequest implements Request {
    private Integer connectorId;
    private ChargePointErrorCode errorCode;
    private String info;
    private ChargePointStatus status;
    private Calendar timestamp;
    private String vendorId;
    private String vendorErrorCode;

    @Override
    public boolean validate() {
        boolean valid = true;
        valid &= isValidConnectorId(connectorId);
        valid &= errorCode != null;
        valid &= status != null;
        return valid;
    }

    public void setConnectorId(Integer connectorId) throws PropertyConstraintException {
        if (!isValidConnectorId(connectorId))
            throw new PropertyConstraintException("connectorId", connectorId);

        this.connectorId = connectorId;
    }

    private boolean isValidConnectorId(Integer connectorId) {
        return connectorId != null && connectorId >= 0;
    }

    public Integer getConnectorId() {
        return connectorId;
    }

    public void setErrorCode(ChargePointErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode.toString();
    }

    public ChargePointErrorCode objErrorCode() {
        return errorCode;
    }

    public void setInfo(String info) throws PropertyConstraintException {
        if (!ModelUtil.validate(info, 50))
            throw new PropertyConstraintException("info", info);

        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public void setStatus(ChargePointStatus status) {
        this.status = status;
    }

    public String getStatus() {
        return status.toString();
    }

    public ChargePointStatus objStatus() {
        return status;
    }

    public void setTimestamp(Calendar timestamp) {
        this.timestamp = timestamp;
    }

    public String getTimestamp() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        formatter.setTimeZone(TimeZone.getTimeZone("GMT+00:00"));
        return formatter.format(timestamp.getTime());
    }

    public Calendar objTimestamp() {
        return timestamp;
    }

    public void setVendorId(String vendorId) throws PropertyConstraintException {
        if (!ModelUtil.validate(vendorId, 255))
            throw new PropertyConstraintException("vendorId", vendorId);

        this.vendorId = vendorId;
    }

    public String getVendorId() {
        return vendorId;
    }

    public void setVendorErrorCode(String vendorErrorCode) throws PropertyConstraintException {
        if (!ModelUtil.validate(vendorErrorCode, 50))
            throw new PropertyConstraintException("vendorErrorCode", vendorErrorCode);

        this.vendorErrorCode = vendorErrorCode;
    }

    public String getVendorErrorCode() {
        return vendorErrorCode;
    }
}