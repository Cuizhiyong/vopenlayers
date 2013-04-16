package org.vaadin.vol.client.ui;

import org.vaadin.vol.client.wrappers.layer.WebMapServiceLayer;

import com.vaadin.client.ApplicationConnection;
import com.vaadin.client.UIDL;

public class VWebMapServiceLayer extends VAbstracMapLayer<WebMapServiceLayer> {

    private String uri;
    private String layers;
    private String display;
    private Boolean isBaseLayer;
    private Double opacity;
    private String format;
    private boolean transparent;
    private String cqlFilter;
    private String projection;
    private String version;

    @Override
    WebMapServiceLayer createLayer() {
        return WebMapServiceLayer.create(display, uri, layers, format,
                cqlFilter, isBaseLayer, transparent, opacity, projection, version);
    }

    @Override
    public void updateFromUIDL(UIDL uidl, ApplicationConnection client) {
        if (!uidl.hasAttribute("cached")) {
            uri = uidl.getStringAttribute("uri");
            layers = uidl.getStringAttribute("layers");
            display = uidl.getStringAttribute("display");
            isBaseLayer = uidl.getBooleanAttribute("isBaseLayer");
            transparent = uidl.getBooleanAttribute("transparent");
            opacity = uidl.getDoubleAttribute("opacity");
            format = uidl.getStringAttribute("format");
            cqlFilter = uidl.hasAttribute("cqlFilter") ? uidl
                    .getStringAttribute("cqlFilter") : null;
            projection = uidl.hasAttribute("projection") ? uidl
                    .getStringAttribute("projection") : null;
            version = uidl.getStringAttribute("version");
        }
        super.updateFromUIDL(uidl, client);
    }

    public String getUri() {
        return uri;
    }

    public String getLayers() {
        return layers;
    }

    public String getDisplay() {
        return display;
    }

    public Boolean isBaseLayer() {
        return isBaseLayer;
    }

    public Double getOpacity() {
        return opacity;
    }

    public String getFormat() {
        return format;
    }

    public boolean isTransparent() {
        return transparent;
    }
    
    public String getVersion() {
        return version;
    }
}
