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
import org.eclipse.digitaltwin.basyx.aasregistry.client.model.Extension;
import org.eclipse.digitaltwin.basyx.aasregistry.client.model.LangStringNameType;
import org.eclipse.digitaltwin.basyx.aasregistry.client.model.LangStringTextType;
import org.eclipse.digitaltwin.basyx.aasregistry.client.model.SpecificAssetId;
import org.eclipse.digitaltwin.basyx.aasregistry.client.model.SubmodelDescriptor;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * AssetAdministrationShellDescriptor
 */
@JsonPropertyOrder({
  AssetAdministrationShellDescriptor.JSON_PROPERTY_DESCRIPTION,
  AssetAdministrationShellDescriptor.JSON_PROPERTY_DISPLAY_NAME,
  AssetAdministrationShellDescriptor.JSON_PROPERTY_EXTENSIONS,
  AssetAdministrationShellDescriptor.JSON_PROPERTY_ADMINISTRATION,
  AssetAdministrationShellDescriptor.JSON_PROPERTY_ASSET_KIND,
  AssetAdministrationShellDescriptor.JSON_PROPERTY_ASSET_TYPE,
  AssetAdministrationShellDescriptor.JSON_PROPERTY_ENDPOINTS,
  AssetAdministrationShellDescriptor.JSON_PROPERTY_GLOBAL_ASSET_ID,
  AssetAdministrationShellDescriptor.JSON_PROPERTY_ID_SHORT,
  AssetAdministrationShellDescriptor.JSON_PROPERTY_ID,
  AssetAdministrationShellDescriptor.JSON_PROPERTY_SPECIFIC_ASSET_IDS,
  AssetAdministrationShellDescriptor.JSON_PROPERTY_SUBMODEL_DESCRIPTORS
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-07-23T10:14:33.883712900+02:00[Europe/Berlin]")
public class AssetAdministrationShellDescriptor {
  public static final String JSON_PROPERTY_DESCRIPTION = "description";
  private List<LangStringTextType> description;

  public static final String JSON_PROPERTY_DISPLAY_NAME = "displayName";
  private List<LangStringNameType> displayName;

  public static final String JSON_PROPERTY_EXTENSIONS = "extensions";
  private List<Extension> extensions;

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

  public AssetAdministrationShellDescriptor() { 
  }

  public AssetAdministrationShellDescriptor description(List<LangStringTextType> description) {
    this.description = description;
    return this;
  }

  public AssetAdministrationShellDescriptor addDescriptionItem(LangStringTextType descriptionItem) {
    if (this.description == null) {
      this.description = new ArrayList<>();
    }
    this.description.add(descriptionItem);
    return this;
  }

   /**
   * Get description
   * @return description
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<LangStringTextType> getDescription() {
    return description;
  }


  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDescription(List<LangStringTextType> description) {
    this.description = description;
  }


  public AssetAdministrationShellDescriptor displayName(List<LangStringNameType> displayName) {
    this.displayName = displayName;
    return this;
  }

  public AssetAdministrationShellDescriptor addDisplayNameItem(LangStringNameType displayNameItem) {
    if (this.displayName == null) {
      this.displayName = new ArrayList<>();
    }
    this.displayName.add(displayNameItem);
    return this;
  }

   /**
   * Get displayName
   * @return displayName
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_DISPLAY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<LangStringNameType> getDisplayName() {
    return displayName;
  }


  @JsonProperty(JSON_PROPERTY_DISPLAY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDisplayName(List<LangStringNameType> displayName) {
    this.displayName = displayName;
  }


  public AssetAdministrationShellDescriptor extensions(List<Extension> extensions) {
    this.extensions = extensions;
    return this;
  }

  public AssetAdministrationShellDescriptor addExtensionsItem(Extension extensionsItem) {
    if (this.extensions == null) {
      this.extensions = new ArrayList<>();
    }
    this.extensions.add(extensionsItem);
    return this;
  }

   /**
   * Get extensions
   * @return extensions
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_EXTENSIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<Extension> getExtensions() {
    return extensions;
  }


  @JsonProperty(JSON_PROPERTY_EXTENSIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setExtensions(List<Extension> extensions) {
    this.extensions = extensions;
  }


  public AssetAdministrationShellDescriptor administration(AdministrativeInformation administration) {
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


  public AssetAdministrationShellDescriptor assetKind(AssetKind assetKind) {
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


  public AssetAdministrationShellDescriptor assetType(String assetType) {
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


  public AssetAdministrationShellDescriptor endpoints(List<Endpoint> endpoints) {
    this.endpoints = endpoints;
    return this;
  }

  public AssetAdministrationShellDescriptor addEndpointsItem(Endpoint endpointsItem) {
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


  public AssetAdministrationShellDescriptor globalAssetId(String globalAssetId) {
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


  public AssetAdministrationShellDescriptor idShort(String idShort) {
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


  public AssetAdministrationShellDescriptor id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @jakarta.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getId() {
    return id;
  }


  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setId(String id) {
    this.id = id;
  }


  public AssetAdministrationShellDescriptor specificAssetIds(List<SpecificAssetId> specificAssetIds) {
    this.specificAssetIds = specificAssetIds;
    return this;
  }

  public AssetAdministrationShellDescriptor addSpecificAssetIdsItem(SpecificAssetId specificAssetIdsItem) {
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


  public AssetAdministrationShellDescriptor submodelDescriptors(List<SubmodelDescriptor> submodelDescriptors) {
    this.submodelDescriptors = submodelDescriptors;
    return this;
  }

  public AssetAdministrationShellDescriptor addSubmodelDescriptorsItem(SubmodelDescriptor submodelDescriptorsItem) {
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
   * Return true if this AssetAdministrationShellDescriptor object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AssetAdministrationShellDescriptor assetAdministrationShellDescriptor = (AssetAdministrationShellDescriptor) o;
    return Objects.equals(this.description, assetAdministrationShellDescriptor.description) &&
        Objects.equals(this.displayName, assetAdministrationShellDescriptor.displayName) &&
        Objects.equals(this.extensions, assetAdministrationShellDescriptor.extensions) &&
        Objects.equals(this.administration, assetAdministrationShellDescriptor.administration) &&
        Objects.equals(this.assetKind, assetAdministrationShellDescriptor.assetKind) &&
        Objects.equals(this.assetType, assetAdministrationShellDescriptor.assetType) &&
        Objects.equals(this.endpoints, assetAdministrationShellDescriptor.endpoints) &&
        Objects.equals(this.globalAssetId, assetAdministrationShellDescriptor.globalAssetId) &&
        Objects.equals(this.idShort, assetAdministrationShellDescriptor.idShort) &&
        Objects.equals(this.id, assetAdministrationShellDescriptor.id) &&
        Objects.equals(this.specificAssetIds, assetAdministrationShellDescriptor.specificAssetIds) &&
        Objects.equals(this.submodelDescriptors, assetAdministrationShellDescriptor.submodelDescriptors);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, displayName, extensions, administration, assetKind, assetType, endpoints, globalAssetId, idShort, id, specificAssetIds, submodelDescriptors);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AssetAdministrationShellDescriptor {\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    extensions: ").append(toIndentedString(extensions)).append("\n");
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

    // add `description` to the URL query string
    if (getDescription() != null) {
      for (int i = 0; i < getDescription().size(); i++) {
        if (getDescription().get(i) != null) {
          joiner.add(getDescription().get(i).toUrlQueryString(String.format("%sdescription%s%s", prefix, suffix,
          "".equals(suffix) ? "" : String.format("%s%d%s", containerPrefix, i, containerSuffix))));
        }
      }
    }

    // add `displayName` to the URL query string
    if (getDisplayName() != null) {
      for (int i = 0; i < getDisplayName().size(); i++) {
        if (getDisplayName().get(i) != null) {
          joiner.add(getDisplayName().get(i).toUrlQueryString(String.format("%sdisplayName%s%s", prefix, suffix,
          "".equals(suffix) ? "" : String.format("%s%d%s", containerPrefix, i, containerSuffix))));
        }
      }
    }

    // add `extensions` to the URL query string
    if (getExtensions() != null) {
      for (int i = 0; i < getExtensions().size(); i++) {
        if (getExtensions().get(i) != null) {
          joiner.add(getExtensions().get(i).toUrlQueryString(String.format("%sextensions%s%s", prefix, suffix,
          "".equals(suffix) ? "" : String.format("%s%d%s", containerPrefix, i, containerSuffix))));
        }
      }
    }

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

