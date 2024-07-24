/*******************************************************************************
 * Copyright (C) 2023 DFKI GmbH (https://www.dfki.de/en/web)
 * 
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 * 
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 * 
 * SPDX-License-Identifier: MIT
 ******************************************************************************/

package org.eclipse.digitaltwin.basyx.aasregistry.client.model;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.StringJoiner;
import java.util.Objects;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.digitaltwin.basyx.aasregistry.client.model.AdministrativeInformation;
import org.eclipse.digitaltwin.basyx.aasregistry.client.model.AssetKind;
import org.eclipse.digitaltwin.basyx.aasregistry.client.model.Endpoint;
import org.eclipse.digitaltwin.basyx.aasregistry.client.model.SpecificAssetId;
import org.eclipse.digitaltwin.basyx.aasregistry.client.model.SubmodelDescriptor;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * AssetAdministrationShellDescriptorAllOf
 */
@JsonPropertyOrder({
  AssetAdministrationShellDescriptorAllOf.JSON_PROPERTY_ADMINISTRATION,
  AssetAdministrationShellDescriptorAllOf.JSON_PROPERTY_ASSET_KIND,
  AssetAdministrationShellDescriptorAllOf.JSON_PROPERTY_ASSET_TYPE,
  AssetAdministrationShellDescriptorAllOf.JSON_PROPERTY_ENDPOINTS,
  AssetAdministrationShellDescriptorAllOf.JSON_PROPERTY_GLOBAL_ASSET_ID,
  AssetAdministrationShellDescriptorAllOf.JSON_PROPERTY_ID_SHORT,
  AssetAdministrationShellDescriptorAllOf.JSON_PROPERTY_ID,
  AssetAdministrationShellDescriptorAllOf.JSON_PROPERTY_SPECIFIC_ASSET_IDS,
  AssetAdministrationShellDescriptorAllOf.JSON_PROPERTY_SUBMODEL_DESCRIPTORS
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-07-23T10:14:33.883712900+02:00[Europe/Berlin]")
public class AssetAdministrationShellDescriptorAllOf {
  public static final String JSON_PROPERTY_ADMINISTRATION = "administration";
  private AdministrativeInformation administration;

  public static final String JSON_PROPERTY_ASSET_KIND = "assetKind";
  private AssetKind assetKind;

  public static final String JSON_PROPERTY_ASSET_TYPE = "assetType";
  private String assetType;

  public static final String JSON_PROPERTY_ENDPOINTS = "endpoints";
  private List<Endpoint> endpoints;

  public static final String JSON_PROPERTY_GLOBAL_ASSET_ID = "globalAssetId";
  private String globalAssetId;

  public static final String JSON_PROPERTY_ID_SHORT = "idShort";
  private String idShort;

  public static final String JSON_PROPERTY_ID = "id";
  private String id;

  public static final String JSON_PROPERTY_SPECIFIC_ASSET_IDS = "specificAssetIds";
  private List<SpecificAssetId> specificAssetIds;

  public static final String JSON_PROPERTY_SUBMODEL_DESCRIPTORS = "submodelDescriptors";
  private List<SubmodelDescriptor> submodelDescriptors;

  public AssetAdministrationShellDescriptorAllOf() { 
  }

  public AssetAdministrationShellDescriptorAllOf administration(AdministrativeInformation administration) {
    this.administration = administration;
    return this;
  }

   /**
   * Get administration
   * @return administration
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ADMINISTRATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public AdministrativeInformation getAdministration() {
    return administration;
  }


  @JsonProperty(JSON_PROPERTY_ADMINISTRATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAdministration(AdministrativeInformation administration) {
    this.administration = administration;
  }


  public AssetAdministrationShellDescriptorAllOf assetKind(AssetKind assetKind) {
    this.assetKind = assetKind;
    return this;
  }

   /**
   * Get assetKind
   * @return assetKind
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ASSET_KIND)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public AssetKind getAssetKind() {
    return assetKind;
  }


  @JsonProperty(JSON_PROPERTY_ASSET_KIND)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAssetKind(AssetKind assetKind) {
    this.assetKind = assetKind;
  }


  public AssetAdministrationShellDescriptorAllOf assetType(String assetType) {
    this.assetType = assetType;
    return this;
  }

   /**
   * Get assetType
   * @return assetType
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ASSET_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getAssetType() {
    return assetType;
  }


  @JsonProperty(JSON_PROPERTY_ASSET_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAssetType(String assetType) {
    this.assetType = assetType;
  }


  public AssetAdministrationShellDescriptorAllOf endpoints(List<Endpoint> endpoints) {
    this.endpoints = endpoints;
    return this;
  }

  public AssetAdministrationShellDescriptorAllOf addEndpointsItem(Endpoint endpointsItem) {
    if (this.endpoints == null) {
      this.endpoints = new ArrayList<>();
    }
    this.endpoints.add(endpointsItem);
    return this;
  }

   /**
   * Get endpoints
   * @return endpoints
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ENDPOINTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<Endpoint> getEndpoints() {
    return endpoints;
  }


  @JsonProperty(JSON_PROPERTY_ENDPOINTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setEndpoints(List<Endpoint> endpoints) {
    this.endpoints = endpoints;
  }


  public AssetAdministrationShellDescriptorAllOf globalAssetId(String globalAssetId) {
    this.globalAssetId = globalAssetId;
    return this;
  }

   /**
   * Get globalAssetId
   * @return globalAssetId
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_GLOBAL_ASSET_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getGlobalAssetId() {
    return globalAssetId;
  }


  @JsonProperty(JSON_PROPERTY_GLOBAL_ASSET_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setGlobalAssetId(String globalAssetId) {
    this.globalAssetId = globalAssetId;
  }


  public AssetAdministrationShellDescriptorAllOf idShort(String idShort) {
    this.idShort = idShort;
    return this;
  }

   /**
   * Get idShort
   * @return idShort
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ID_SHORT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getIdShort() {
    return idShort;
  }


  @JsonProperty(JSON_PROPERTY_ID_SHORT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setIdShort(String idShort) {
    this.idShort = idShort;
  }


  public AssetAdministrationShellDescriptorAllOf id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getId() {
    return id;
  }


  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setId(String id) {
    this.id = id;
  }


  public AssetAdministrationShellDescriptorAllOf specificAssetIds(List<SpecificAssetId> specificAssetIds) {
    this.specificAssetIds = specificAssetIds;
    return this;
  }

  public AssetAdministrationShellDescriptorAllOf addSpecificAssetIdsItem(SpecificAssetId specificAssetIdsItem) {
    if (this.specificAssetIds == null) {
      this.specificAssetIds = new ArrayList<>();
    }
    this.specificAssetIds.add(specificAssetIdsItem);
    return this;
  }

   /**
   * Get specificAssetIds
   * @return specificAssetIds
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_SPECIFIC_ASSET_IDS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<SpecificAssetId> getSpecificAssetIds() {
    return specificAssetIds;
  }


  @JsonProperty(JSON_PROPERTY_SPECIFIC_ASSET_IDS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSpecificAssetIds(List<SpecificAssetId> specificAssetIds) {
    this.specificAssetIds = specificAssetIds;
  }


  public AssetAdministrationShellDescriptorAllOf submodelDescriptors(List<SubmodelDescriptor> submodelDescriptors) {
    this.submodelDescriptors = submodelDescriptors;
    return this;
  }

  public AssetAdministrationShellDescriptorAllOf addSubmodelDescriptorsItem(SubmodelDescriptor submodelDescriptorsItem) {
    if (this.submodelDescriptors == null) {
      this.submodelDescriptors = new ArrayList<>();
    }
    this.submodelDescriptors.add(submodelDescriptorsItem);
    return this;
  }

   /**
   * Get submodelDescriptors
   * @return submodelDescriptors
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_SUBMODEL_DESCRIPTORS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<SubmodelDescriptor> getSubmodelDescriptors() {
    return submodelDescriptors;
  }


  @JsonProperty(JSON_PROPERTY_SUBMODEL_DESCRIPTORS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSubmodelDescriptors(List<SubmodelDescriptor> submodelDescriptors) {
    this.submodelDescriptors = submodelDescriptors;
  }


  /**
   * Return true if this AssetAdministrationShellDescriptor_allOf object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AssetAdministrationShellDescriptorAllOf assetAdministrationShellDescriptorAllOf = (AssetAdministrationShellDescriptorAllOf) o;
    return Objects.equals(this.administration, assetAdministrationShellDescriptorAllOf.administration) &&
        Objects.equals(this.assetKind, assetAdministrationShellDescriptorAllOf.assetKind) &&
        Objects.equals(this.assetType, assetAdministrationShellDescriptorAllOf.assetType) &&
        Objects.equals(this.endpoints, assetAdministrationShellDescriptorAllOf.endpoints) &&
        Objects.equals(this.globalAssetId, assetAdministrationShellDescriptorAllOf.globalAssetId) &&
        Objects.equals(this.idShort, assetAdministrationShellDescriptorAllOf.idShort) &&
        Objects.equals(this.id, assetAdministrationShellDescriptorAllOf.id) &&
        Objects.equals(this.specificAssetIds, assetAdministrationShellDescriptorAllOf.specificAssetIds) &&
        Objects.equals(this.submodelDescriptors, assetAdministrationShellDescriptorAllOf.submodelDescriptors);
  }

  @Override
  public int hashCode() {
    return Objects.hash(administration, assetKind, assetType, endpoints, globalAssetId, idShort, id, specificAssetIds, submodelDescriptors);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AssetAdministrationShellDescriptorAllOf {\n");
    sb.append("    administration: ").append(toIndentedString(administration)).append("\n");
    sb.append("    assetKind: ").append(toIndentedString(assetKind)).append("\n");
    sb.append("    assetType: ").append(toIndentedString(assetType)).append("\n");
    sb.append("    endpoints: ").append(toIndentedString(endpoints)).append("\n");
    sb.append("    globalAssetId: ").append(toIndentedString(globalAssetId)).append("\n");
    sb.append("    idShort: ").append(toIndentedString(idShort)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    specificAssetIds: ").append(toIndentedString(specificAssetIds)).append("\n");
    sb.append("    submodelDescriptors: ").append(toIndentedString(submodelDescriptors)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

  /**
   * Convert the instance into URL query string.
   *
   * @return URL query string
   */
  public String toUrlQueryString() {
    return toUrlQueryString(null);
  }

  /**
   * Convert the instance into URL query string.
   *
   * @param prefix prefix of the query string
   * @return URL query string
   */
  public String toUrlQueryString(String prefix) {
    String suffix = "";
    String containerSuffix = "";
    String containerPrefix = "";
    if (prefix == null) {
      // style=form, explode=true, e.g. /pet?name=cat&type=manx
      prefix = "";
    } else {
      // deepObject style e.g. /pet?id[name]=cat&id[type]=manx
      prefix = prefix + "[";
      suffix = "]";
      containerSuffix = "]";
      containerPrefix = "[";
    }

    StringJoiner joiner = new StringJoiner("&");

    // add `administration` to the URL query string
    if (getAdministration() != null) {
      joiner.add(getAdministration().toUrlQueryString(prefix + "administration" + suffix));
    }

    // add `assetKind` to the URL query string
    if (getAssetKind() != null) {
      joiner.add(String.format("%sassetKind%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getAssetKind()), StandardCharsets.UTF_8).replaceAll("\\+", "%20")));
    }

    // add `assetType` to the URL query string
    if (getAssetType() != null) {
      joiner.add(String.format("%sassetType%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getAssetType()), StandardCharsets.UTF_8).replaceAll("\\+", "%20")));
    }

    // add `endpoints` to the URL query string
    if (getEndpoints() != null) {
      for (int i = 0; i < getEndpoints().size(); i++) {
        if (getEndpoints().get(i) != null) {
          joiner.add(getEndpoints().get(i).toUrlQueryString(String.format("%sendpoints%s%s", prefix, suffix,
          "".equals(suffix) ? "" : String.format("%s%d%s", containerPrefix, i, containerSuffix))));
        }
      }
    }

    // add `globalAssetId` to the URL query string
    if (getGlobalAssetId() != null) {
      joiner.add(String.format("%sglobalAssetId%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getGlobalAssetId()), StandardCharsets.UTF_8).replaceAll("\\+", "%20")));
    }

    // add `idShort` to the URL query string
    if (getIdShort() != null) {
      joiner.add(String.format("%sidShort%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getIdShort()), StandardCharsets.UTF_8).replaceAll("\\+", "%20")));
    }

    // add `id` to the URL query string
    if (getId() != null) {
      joiner.add(String.format("%sid%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getId()), StandardCharsets.UTF_8).replaceAll("\\+", "%20")));
    }

    // add `specificAssetIds` to the URL query string
    if (getSpecificAssetIds() != null) {
      for (int i = 0; i < getSpecificAssetIds().size(); i++) {
        if (getSpecificAssetIds().get(i) != null) {
          joiner.add(getSpecificAssetIds().get(i).toUrlQueryString(String.format("%sspecificAssetIds%s%s", prefix, suffix,
          "".equals(suffix) ? "" : String.format("%s%d%s", containerPrefix, i, containerSuffix))));
        }
      }
    }

    // add `submodelDescriptors` to the URL query string
    if (getSubmodelDescriptors() != null) {
      for (int i = 0; i < getSubmodelDescriptors().size(); i++) {
        if (getSubmodelDescriptors().get(i) != null) {
          joiner.add(getSubmodelDescriptors().get(i).toUrlQueryString(String.format("%ssubmodelDescriptors%s%s", prefix, suffix,
          "".equals(suffix) ? "" : String.format("%s%d%s", containerPrefix, i, containerSuffix))));
        }
      }
    }

    return joiner.toString();
  }
}

