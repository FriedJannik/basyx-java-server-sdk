package org.gradle.accessors.dm;

import org.gradle.api.NonNullApi;
import org.gradle.api.artifacts.MinimalExternalModuleDependency;
import org.gradle.plugin.use.PluginDependency;
import org.gradle.api.artifacts.ExternalModuleDependencyBundle;
import org.gradle.api.artifacts.MutableVersionConstraint;
import org.gradle.api.provider.Provider;
import org.gradle.api.model.ObjectFactory;
import org.gradle.api.provider.ProviderFactory;
import org.gradle.api.internal.catalog.AbstractExternalDependencyFactory;
import org.gradle.api.internal.catalog.DefaultVersionCatalog;
import java.util.Map;
import org.gradle.api.internal.attributes.ImmutableAttributesFactory;
import org.gradle.api.internal.artifacts.dsl.CapabilityNotationParser;
import javax.inject.Inject;

/**
 * A catalog of dependencies accessible via the {@code libs} extension.
 */
@NonNullApi
public class LibrariesForLibs extends AbstractExternalDependencyFactory {

    private final AbstractExternalDependencyFactory owner = this;
    private final ComLibraryAccessors laccForComLibraryAccessors = new ComLibraryAccessors(owner);
    private final CommonsLibraryAccessors laccForCommonsLibraryAccessors = new CommonsLibraryAccessors(owner);
    private final IoLibraryAccessors laccForIoLibraryAccessors = new IoLibraryAccessors(owner);
    private final JakartaLibraryAccessors laccForJakartaLibraryAccessors = new JakartaLibraryAccessors(owner);
    private final OrgLibraryAccessors laccForOrgLibraryAccessors = new OrgLibraryAccessors(owner);
    private final VersionAccessors vaccForVersionAccessors = new VersionAccessors(providers, config);
    private final BundleAccessors baccForBundleAccessors = new BundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);
    private final PluginAccessors paccForPluginAccessors = new PluginAccessors(providers, config);

    @Inject
    public LibrariesForLibs(DefaultVersionCatalog config, ProviderFactory providers, ObjectFactory objects, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) {
        super(config, providers, objects, attributesFactory, capabilityNotationParser);
    }

    /**
     * Group of libraries at <b>com</b>
     */
    public ComLibraryAccessors getCom() {
        return laccForComLibraryAccessors;
    }

    /**
     * Group of libraries at <b>commons</b>
     */
    public CommonsLibraryAccessors getCommons() {
        return laccForCommonsLibraryAccessors;
    }

    /**
     * Group of libraries at <b>io</b>
     */
    public IoLibraryAccessors getIo() {
        return laccForIoLibraryAccessors;
    }

    /**
     * Group of libraries at <b>jakarta</b>
     */
    public JakartaLibraryAccessors getJakarta() {
        return laccForJakartaLibraryAccessors;
    }

    /**
     * Group of libraries at <b>org</b>
     */
    public OrgLibraryAccessors getOrg() {
        return laccForOrgLibraryAccessors;
    }

    /**
     * Group of versions at <b>versions</b>
     */
    public VersionAccessors getVersions() {
        return vaccForVersionAccessors;
    }

    /**
     * Group of bundles at <b>bundles</b>
     */
    public BundleAccessors getBundles() {
        return baccForBundleAccessors;
    }

    /**
     * Group of plugins at <b>plugins</b>
     */
    public PluginAccessors getPlugins() {
        return paccForPluginAccessors;
    }

    public static class ComLibraryAccessors extends SubDependencyFactory {
        private final ComFasterxmlLibraryAccessors laccForComFasterxmlLibraryAccessors = new ComFasterxmlLibraryAccessors(owner);
        private final ComGithubLibraryAccessors laccForComGithubLibraryAccessors = new ComGithubLibraryAccessors(owner);
        private final ComGoogleLibraryAccessors laccForComGoogleLibraryAccessors = new ComGoogleLibraryAccessors(owner);
        private final ComNimbusdsLibraryAccessors laccForComNimbusdsLibraryAccessors = new ComNimbusdsLibraryAccessors(owner);

        public ComLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.fasterxml</b>
         */
        public ComFasterxmlLibraryAccessors getFasterxml() {
            return laccForComFasterxmlLibraryAccessors;
        }

        /**
         * Group of libraries at <b>com.github</b>
         */
        public ComGithubLibraryAccessors getGithub() {
            return laccForComGithubLibraryAccessors;
        }

        /**
         * Group of libraries at <b>com.google</b>
         */
        public ComGoogleLibraryAccessors getGoogle() {
            return laccForComGoogleLibraryAccessors;
        }

        /**
         * Group of libraries at <b>com.nimbusds</b>
         */
        public ComNimbusdsLibraryAccessors getNimbusds() {
            return laccForComNimbusdsLibraryAccessors;
        }

    }

    public static class ComFasterxmlLibraryAccessors extends SubDependencyFactory {
        private final ComFasterxmlJacksonLibraryAccessors laccForComFasterxmlJacksonLibraryAccessors = new ComFasterxmlJacksonLibraryAccessors(owner);

        public ComFasterxmlLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.fasterxml.jackson</b>
         */
        public ComFasterxmlJacksonLibraryAccessors getJackson() {
            return laccForComFasterxmlJacksonLibraryAccessors;
        }

    }

    public static class ComFasterxmlJacksonLibraryAccessors extends SubDependencyFactory {
        private final ComFasterxmlJacksonCoreLibraryAccessors laccForComFasterxmlJacksonCoreLibraryAccessors = new ComFasterxmlJacksonCoreLibraryAccessors(owner);
        private final ComFasterxmlJacksonDatatypeLibraryAccessors laccForComFasterxmlJacksonDatatypeLibraryAccessors = new ComFasterxmlJacksonDatatypeLibraryAccessors(owner);

        public ComFasterxmlJacksonLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.fasterxml.jackson.core</b>
         */
        public ComFasterxmlJacksonCoreLibraryAccessors getCore() {
            return laccForComFasterxmlJacksonCoreLibraryAccessors;
        }

        /**
         * Group of libraries at <b>com.fasterxml.jackson.datatype</b>
         */
        public ComFasterxmlJacksonDatatypeLibraryAccessors getDatatype() {
            return laccForComFasterxmlJacksonDatatypeLibraryAccessors;
        }

    }

    public static class ComFasterxmlJacksonCoreLibraryAccessors extends SubDependencyFactory {
        private final ComFasterxmlJacksonCoreJacksonLibraryAccessors laccForComFasterxmlJacksonCoreJacksonLibraryAccessors = new ComFasterxmlJacksonCoreJacksonLibraryAccessors(owner);

        public ComFasterxmlJacksonCoreLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.fasterxml.jackson.core.jackson</b>
         */
        public ComFasterxmlJacksonCoreJacksonLibraryAccessors getJackson() {
            return laccForComFasterxmlJacksonCoreJacksonLibraryAccessors;
        }

    }

    public static class ComFasterxmlJacksonCoreJacksonLibraryAccessors extends SubDependencyFactory {

        public ComFasterxmlJacksonCoreJacksonLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>annotations</b> with <b>com.fasterxml.jackson.core:jackson-annotations</b> coordinates and
         * with version reference <b>com.fasterxml.jackson.core.jackson.annotations</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getAnnotations() {
            return create("com.fasterxml.jackson.core.jackson.annotations");
        }

        /**
         * Dependency provider for <b>core</b> with <b>com.fasterxml.jackson.core:jackson-core</b> coordinates and
         * with version reference <b>com.fasterxml.jackson.core.jackson.core</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getCore() {
            return create("com.fasterxml.jackson.core.jackson.core");
        }

        /**
         * Dependency provider for <b>databind</b> with <b>com.fasterxml.jackson.core:jackson-databind</b> coordinates and
         * with version reference <b>com.fasterxml.jackson.core.jackson.databind</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getDatabind() {
            return create("com.fasterxml.jackson.core.jackson.databind");
        }

    }

    public static class ComFasterxmlJacksonDatatypeLibraryAccessors extends SubDependencyFactory {
        private final ComFasterxmlJacksonDatatypeJacksonLibraryAccessors laccForComFasterxmlJacksonDatatypeJacksonLibraryAccessors = new ComFasterxmlJacksonDatatypeJacksonLibraryAccessors(owner);

        public ComFasterxmlJacksonDatatypeLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.fasterxml.jackson.datatype.jackson</b>
         */
        public ComFasterxmlJacksonDatatypeJacksonLibraryAccessors getJackson() {
            return laccForComFasterxmlJacksonDatatypeJacksonLibraryAccessors;
        }

    }

    public static class ComFasterxmlJacksonDatatypeJacksonLibraryAccessors extends SubDependencyFactory {
        private final ComFasterxmlJacksonDatatypeJacksonDatatypeLibraryAccessors laccForComFasterxmlJacksonDatatypeJacksonDatatypeLibraryAccessors = new ComFasterxmlJacksonDatatypeJacksonDatatypeLibraryAccessors(owner);

        public ComFasterxmlJacksonDatatypeJacksonLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.fasterxml.jackson.datatype.jackson.datatype</b>
         */
        public ComFasterxmlJacksonDatatypeJacksonDatatypeLibraryAccessors getDatatype() {
            return laccForComFasterxmlJacksonDatatypeJacksonDatatypeLibraryAccessors;
        }

    }

    public static class ComFasterxmlJacksonDatatypeJacksonDatatypeLibraryAccessors extends SubDependencyFactory {

        public ComFasterxmlJacksonDatatypeJacksonDatatypeLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>jsr310</b> with <b>com.fasterxml.jackson.datatype:jackson-datatype-jsr310</b> coordinates and
         * with version reference <b>com.fasterxml.jackson.datatype.jackson.datatype.jsr310</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJsr310() {
            return create("com.fasterxml.jackson.datatype.jackson.datatype.jsr310");
        }

    }

    public static class ComGithubLibraryAccessors extends SubDependencyFactory {
        private final ComGithubSpullaraLibraryAccessors laccForComGithubSpullaraLibraryAccessors = new ComGithubSpullaraLibraryAccessors(owner);

        public ComGithubLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.github.spullara</b>
         */
        public ComGithubSpullaraLibraryAccessors getSpullara() {
            return laccForComGithubSpullaraLibraryAccessors;
        }

    }

    public static class ComGithubSpullaraLibraryAccessors extends SubDependencyFactory {
        private final ComGithubSpullaraMustacheLibraryAccessors laccForComGithubSpullaraMustacheLibraryAccessors = new ComGithubSpullaraMustacheLibraryAccessors(owner);

        public ComGithubSpullaraLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.github.spullara.mustache</b>
         */
        public ComGithubSpullaraMustacheLibraryAccessors getMustache() {
            return laccForComGithubSpullaraMustacheLibraryAccessors;
        }

    }

    public static class ComGithubSpullaraMustacheLibraryAccessors extends SubDependencyFactory {
        private final ComGithubSpullaraMustacheJavaLibraryAccessors laccForComGithubSpullaraMustacheJavaLibraryAccessors = new ComGithubSpullaraMustacheJavaLibraryAccessors(owner);

        public ComGithubSpullaraMustacheLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.github.spullara.mustache.java</b>
         */
        public ComGithubSpullaraMustacheJavaLibraryAccessors getJava() {
            return laccForComGithubSpullaraMustacheJavaLibraryAccessors;
        }

    }

    public static class ComGithubSpullaraMustacheJavaLibraryAccessors extends SubDependencyFactory {

        public ComGithubSpullaraMustacheJavaLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>compiler</b> with <b>com.github.spullara.mustache.java:compiler</b> coordinates and
         * with version reference <b>com.github.spullara.mustache.java.compiler</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getCompiler() {
            return create("com.github.spullara.mustache.java.compiler");
        }

    }

    public static class ComGoogleLibraryAccessors extends SubDependencyFactory {
        private final ComGoogleCodeLibraryAccessors laccForComGoogleCodeLibraryAccessors = new ComGoogleCodeLibraryAccessors(owner);
        private final ComGoogleGuavaLibraryAccessors laccForComGoogleGuavaLibraryAccessors = new ComGoogleGuavaLibraryAccessors(owner);

        public ComGoogleLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.google.code</b>
         */
        public ComGoogleCodeLibraryAccessors getCode() {
            return laccForComGoogleCodeLibraryAccessors;
        }

        /**
         * Group of libraries at <b>com.google.guava</b>
         */
        public ComGoogleGuavaLibraryAccessors getGuava() {
            return laccForComGoogleGuavaLibraryAccessors;
        }

    }

    public static class ComGoogleCodeLibraryAccessors extends SubDependencyFactory {
        private final ComGoogleCodeFindbugsLibraryAccessors laccForComGoogleCodeFindbugsLibraryAccessors = new ComGoogleCodeFindbugsLibraryAccessors(owner);
        private final ComGoogleCodeGsonLibraryAccessors laccForComGoogleCodeGsonLibraryAccessors = new ComGoogleCodeGsonLibraryAccessors(owner);

        public ComGoogleCodeLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.google.code.findbugs</b>
         */
        public ComGoogleCodeFindbugsLibraryAccessors getFindbugs() {
            return laccForComGoogleCodeFindbugsLibraryAccessors;
        }

        /**
         * Group of libraries at <b>com.google.code.gson</b>
         */
        public ComGoogleCodeGsonLibraryAccessors getGson() {
            return laccForComGoogleCodeGsonLibraryAccessors;
        }

    }

    public static class ComGoogleCodeFindbugsLibraryAccessors extends SubDependencyFactory {

        public ComGoogleCodeFindbugsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>jsr305</b> with <b>com.google.code.findbugs:jsr305</b> coordinates and
         * with version reference <b>com.google.code.findbugs.jsr305</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJsr305() {
            return create("com.google.code.findbugs.jsr305");
        }

    }

    public static class ComGoogleCodeGsonLibraryAccessors extends SubDependencyFactory {

        public ComGoogleCodeGsonLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>gson</b> with <b>com.google.code.gson:gson</b> coordinates and
         * with version reference <b>com.google.code.gson.gson</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getGson() {
            return create("com.google.code.gson.gson");
        }

    }

    public static class ComGoogleGuavaLibraryAccessors extends SubDependencyFactory {

        public ComGoogleGuavaLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>guava</b> with <b>com.google.guava:guava</b> coordinates and
         * with version reference <b>com.google.guava.guava</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getGuava() {
            return create("com.google.guava.guava");
        }

    }

    public static class ComNimbusdsLibraryAccessors extends SubDependencyFactory {
        private final ComNimbusdsOauth2LibraryAccessors laccForComNimbusdsOauth2LibraryAccessors = new ComNimbusdsOauth2LibraryAccessors(owner);

        public ComNimbusdsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.nimbusds.oauth2</b>
         */
        public ComNimbusdsOauth2LibraryAccessors getOauth2() {
            return laccForComNimbusdsOauth2LibraryAccessors;
        }

    }

    public static class ComNimbusdsOauth2LibraryAccessors extends SubDependencyFactory {
        private final ComNimbusdsOauth2OidcLibraryAccessors laccForComNimbusdsOauth2OidcLibraryAccessors = new ComNimbusdsOauth2OidcLibraryAccessors(owner);

        public ComNimbusdsOauth2LibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.nimbusds.oauth2.oidc</b>
         */
        public ComNimbusdsOauth2OidcLibraryAccessors getOidc() {
            return laccForComNimbusdsOauth2OidcLibraryAccessors;
        }

    }

    public static class ComNimbusdsOauth2OidcLibraryAccessors extends SubDependencyFactory {

        public ComNimbusdsOauth2OidcLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>sdk</b> with <b>com.nimbusds:oauth2-oidc-sdk</b> coordinates and
         * with version reference <b>com.nimbusds.oauth2.oidc.sdk</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getSdk() {
            return create("com.nimbusds.oauth2.oidc.sdk");
        }

    }

    public static class CommonsLibraryAccessors extends SubDependencyFactory {
        private final CommonsIoLibraryAccessors laccForCommonsIoLibraryAccessors = new CommonsIoLibraryAccessors(owner);

        public CommonsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>commons.io</b>
         */
        public CommonsIoLibraryAccessors getIo() {
            return laccForCommonsIoLibraryAccessors;
        }

    }

    public static class CommonsIoLibraryAccessors extends SubDependencyFactory {
        private final CommonsIoCommonsLibraryAccessors laccForCommonsIoCommonsLibraryAccessors = new CommonsIoCommonsLibraryAccessors(owner);

        public CommonsIoLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>commons.io.commons</b>
         */
        public CommonsIoCommonsLibraryAccessors getCommons() {
            return laccForCommonsIoCommonsLibraryAccessors;
        }

    }

    public static class CommonsIoCommonsLibraryAccessors extends SubDependencyFactory {

        public CommonsIoCommonsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>io</b> with <b>commons-io:commons-io</b> coordinates and
         * with version reference <b>commons.io.commons.io</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getIo() {
            return create("commons.io.commons.io");
        }

    }

    public static class IoLibraryAccessors extends SubDependencyFactory {
        private final IoMoquetteLibraryAccessors laccForIoMoquetteLibraryAccessors = new IoMoquetteLibraryAccessors(owner);

        public IoLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>io.moquette</b>
         */
        public IoMoquetteLibraryAccessors getMoquette() {
            return laccForIoMoquetteLibraryAccessors;
        }

    }

    public static class IoMoquetteLibraryAccessors extends SubDependencyFactory {
        private final IoMoquetteMoquetteLibraryAccessors laccForIoMoquetteMoquetteLibraryAccessors = new IoMoquetteMoquetteLibraryAccessors(owner);

        public IoMoquetteLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>io.moquette.moquette</b>
         */
        public IoMoquetteMoquetteLibraryAccessors getMoquette() {
            return laccForIoMoquetteMoquetteLibraryAccessors;
        }

    }

    public static class IoMoquetteMoquetteLibraryAccessors extends SubDependencyFactory {

        public IoMoquetteMoquetteLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>broker</b> with <b>io.moquette:moquette-broker</b> coordinates and
         * with version reference <b>io.moquette.moquette.broker</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getBroker() {
            return create("io.moquette.moquette.broker");
        }

    }

    public static class JakartaLibraryAccessors extends SubDependencyFactory {
        private final JakartaAnnotationLibraryAccessors laccForJakartaAnnotationLibraryAccessors = new JakartaAnnotationLibraryAccessors(owner);
        private final JakartaValidationLibraryAccessors laccForJakartaValidationLibraryAccessors = new JakartaValidationLibraryAccessors(owner);

        public JakartaLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>jakarta.annotation</b>
         */
        public JakartaAnnotationLibraryAccessors getAnnotation() {
            return laccForJakartaAnnotationLibraryAccessors;
        }

        /**
         * Group of libraries at <b>jakarta.validation</b>
         */
        public JakartaValidationLibraryAccessors getValidation() {
            return laccForJakartaValidationLibraryAccessors;
        }

    }

    public static class JakartaAnnotationLibraryAccessors extends SubDependencyFactory {
        private final JakartaAnnotationJakartaLibraryAccessors laccForJakartaAnnotationJakartaLibraryAccessors = new JakartaAnnotationJakartaLibraryAccessors(owner);

        public JakartaAnnotationLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>jakarta.annotation.jakarta</b>
         */
        public JakartaAnnotationJakartaLibraryAccessors getJakarta() {
            return laccForJakartaAnnotationJakartaLibraryAccessors;
        }

    }

    public static class JakartaAnnotationJakartaLibraryAccessors extends SubDependencyFactory {
        private final JakartaAnnotationJakartaAnnotationLibraryAccessors laccForJakartaAnnotationJakartaAnnotationLibraryAccessors = new JakartaAnnotationJakartaAnnotationLibraryAccessors(owner);

        public JakartaAnnotationJakartaLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>jakarta.annotation.jakarta.annotation</b>
         */
        public JakartaAnnotationJakartaAnnotationLibraryAccessors getAnnotation() {
            return laccForJakartaAnnotationJakartaAnnotationLibraryAccessors;
        }

    }

    public static class JakartaAnnotationJakartaAnnotationLibraryAccessors extends SubDependencyFactory {

        public JakartaAnnotationJakartaAnnotationLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>api</b> with <b>jakarta.annotation:jakarta.annotation-api</b> coordinates and
         * with version reference <b>jakarta.annotation.jakarta.annotation.api</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getApi() {
            return create("jakarta.annotation.jakarta.annotation.api");
        }

    }

    public static class JakartaValidationLibraryAccessors extends SubDependencyFactory {
        private final JakartaValidationJakartaLibraryAccessors laccForJakartaValidationJakartaLibraryAccessors = new JakartaValidationJakartaLibraryAccessors(owner);

        public JakartaValidationLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>jakarta.validation.jakarta</b>
         */
        public JakartaValidationJakartaLibraryAccessors getJakarta() {
            return laccForJakartaValidationJakartaLibraryAccessors;
        }

    }

    public static class JakartaValidationJakartaLibraryAccessors extends SubDependencyFactory {
        private final JakartaValidationJakartaValidationLibraryAccessors laccForJakartaValidationJakartaValidationLibraryAccessors = new JakartaValidationJakartaValidationLibraryAccessors(owner);

        public JakartaValidationJakartaLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>jakarta.validation.jakarta.validation</b>
         */
        public JakartaValidationJakartaValidationLibraryAccessors getValidation() {
            return laccForJakartaValidationJakartaValidationLibraryAccessors;
        }

    }

    public static class JakartaValidationJakartaValidationLibraryAccessors extends SubDependencyFactory {

        public JakartaValidationJakartaValidationLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>api</b> with <b>jakarta.validation:jakarta.validation-api</b> coordinates and
         * with version reference <b>jakarta.validation.jakarta.validation.api</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getApi() {
            return create("jakarta.validation.jakarta.validation.api");
        }

    }

    public static class OrgLibraryAccessors extends SubDependencyFactory {
        private final OrgApacheLibraryAccessors laccForOrgApacheLibraryAccessors = new OrgApacheLibraryAccessors(owner);
        private final OrgEclipseLibraryAccessors laccForOrgEclipseLibraryAccessors = new OrgEclipseLibraryAccessors(owner);
        private final OrgHibernateLibraryAccessors laccForOrgHibernateLibraryAccessors = new OrgHibernateLibraryAccessors(owner);
        private final OrgJsonLibraryAccessors laccForOrgJsonLibraryAccessors = new OrgJsonLibraryAccessors(owner);
        private final OrgJunitLibraryAccessors laccForOrgJunitLibraryAccessors = new OrgJunitLibraryAccessors(owner);
        private final OrgMockLibraryAccessors laccForOrgMockLibraryAccessors = new OrgMockLibraryAccessors(owner);
        private final OrgMockitoLibraryAccessors laccForOrgMockitoLibraryAccessors = new OrgMockitoLibraryAccessors(owner);
        private final OrgOpenapitoolsLibraryAccessors laccForOrgOpenapitoolsLibraryAccessors = new OrgOpenapitoolsLibraryAccessors(owner);
        private final OrgProjectlombokLibraryAccessors laccForOrgProjectlombokLibraryAccessors = new OrgProjectlombokLibraryAccessors(owner);
        private final OrgReflectionsLibraryAccessors laccForOrgReflectionsLibraryAccessors = new OrgReflectionsLibraryAccessors(owner);
        private final OrgSlf4jLibraryAccessors laccForOrgSlf4jLibraryAccessors = new OrgSlf4jLibraryAccessors(owner);
        private final OrgSpringdocLibraryAccessors laccForOrgSpringdocLibraryAccessors = new OrgSpringdocLibraryAccessors(owner);
        private final OrgSpringframeworkLibraryAccessors laccForOrgSpringframeworkLibraryAccessors = new OrgSpringframeworkLibraryAccessors(owner);
        private final OrgXmlunitLibraryAccessors laccForOrgXmlunitLibraryAccessors = new OrgXmlunitLibraryAccessors(owner);
        private final OrgYamlLibraryAccessors laccForOrgYamlLibraryAccessors = new OrgYamlLibraryAccessors(owner);

        public OrgLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.apache</b>
         */
        public OrgApacheLibraryAccessors getApache() {
            return laccForOrgApacheLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.eclipse</b>
         */
        public OrgEclipseLibraryAccessors getEclipse() {
            return laccForOrgEclipseLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.hibernate</b>
         */
        public OrgHibernateLibraryAccessors getHibernate() {
            return laccForOrgHibernateLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.json</b>
         */
        public OrgJsonLibraryAccessors getJson() {
            return laccForOrgJsonLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.junit</b>
         */
        public OrgJunitLibraryAccessors getJunit() {
            return laccForOrgJunitLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.mock</b>
         */
        public OrgMockLibraryAccessors getMock() {
            return laccForOrgMockLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.mockito</b>
         */
        public OrgMockitoLibraryAccessors getMockito() {
            return laccForOrgMockitoLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.openapitools</b>
         */
        public OrgOpenapitoolsLibraryAccessors getOpenapitools() {
            return laccForOrgOpenapitoolsLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.projectlombok</b>
         */
        public OrgProjectlombokLibraryAccessors getProjectlombok() {
            return laccForOrgProjectlombokLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.reflections</b>
         */
        public OrgReflectionsLibraryAccessors getReflections() {
            return laccForOrgReflectionsLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.slf4j</b>
         */
        public OrgSlf4jLibraryAccessors getSlf4j() {
            return laccForOrgSlf4jLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.springdoc</b>
         */
        public OrgSpringdocLibraryAccessors getSpringdoc() {
            return laccForOrgSpringdocLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.springframework</b>
         */
        public OrgSpringframeworkLibraryAccessors getSpringframework() {
            return laccForOrgSpringframeworkLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.xmlunit</b>
         */
        public OrgXmlunitLibraryAccessors getXmlunit() {
            return laccForOrgXmlunitLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.yaml</b>
         */
        public OrgYamlLibraryAccessors getYaml() {
            return laccForOrgYamlLibraryAccessors;
        }

    }

    public static class OrgApacheLibraryAccessors extends SubDependencyFactory {
        private final OrgApacheCommonsLibraryAccessors laccForOrgApacheCommonsLibraryAccessors = new OrgApacheCommonsLibraryAccessors(owner);
        private final OrgApacheHttpcomponentsLibraryAccessors laccForOrgApacheHttpcomponentsLibraryAccessors = new OrgApacheHttpcomponentsLibraryAccessors(owner);
        private final OrgApacheMavenLibraryAccessors laccForOrgApacheMavenLibraryAccessors = new OrgApacheMavenLibraryAccessors(owner);
        private final OrgApachePoiLibraryAccessors laccForOrgApachePoiLibraryAccessors = new OrgApachePoiLibraryAccessors(owner);
        private final OrgApacheTikaLibraryAccessors laccForOrgApacheTikaLibraryAccessors = new OrgApacheTikaLibraryAccessors(owner);

        public OrgApacheLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.apache.commons</b>
         */
        public OrgApacheCommonsLibraryAccessors getCommons() {
            return laccForOrgApacheCommonsLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.apache.httpcomponents</b>
         */
        public OrgApacheHttpcomponentsLibraryAccessors getHttpcomponents() {
            return laccForOrgApacheHttpcomponentsLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.apache.maven</b>
         */
        public OrgApacheMavenLibraryAccessors getMaven() {
            return laccForOrgApacheMavenLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.apache.poi</b>
         */
        public OrgApachePoiLibraryAccessors getPoi() {
            return laccForOrgApachePoiLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.apache.tika</b>
         */
        public OrgApacheTikaLibraryAccessors getTika() {
            return laccForOrgApacheTikaLibraryAccessors;
        }

    }

    public static class OrgApacheCommonsLibraryAccessors extends SubDependencyFactory {
        private final OrgApacheCommonsCommonsLibraryAccessors laccForOrgApacheCommonsCommonsLibraryAccessors = new OrgApacheCommonsCommonsLibraryAccessors(owner);

        public OrgApacheCommonsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.apache.commons.commons</b>
         */
        public OrgApacheCommonsCommonsLibraryAccessors getCommons() {
            return laccForOrgApacheCommonsCommonsLibraryAccessors;
        }

    }

    public static class OrgApacheCommonsCommonsLibraryAccessors extends SubDependencyFactory {

        public OrgApacheCommonsCommonsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>lang3</b> with <b>org.apache.commons:commons-lang3</b> coordinates and
         * with version reference <b>org.apache.commons.commons.lang3</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getLang3() {
            return create("org.apache.commons.commons.lang3");
        }

    }

    public static class OrgApacheHttpcomponentsLibraryAccessors extends SubDependencyFactory {
        private final OrgApacheHttpcomponentsClient5LibraryAccessors laccForOrgApacheHttpcomponentsClient5LibraryAccessors = new OrgApacheHttpcomponentsClient5LibraryAccessors(owner);

        public OrgApacheHttpcomponentsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>httpmime</b> with <b>org.apache.httpcomponents:httpmime</b> coordinates and
         * with version reference <b>org.apache.httpcomponents.httpmime</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getHttpmime() {
            return create("org.apache.httpcomponents.httpmime");
        }

        /**
         * Group of libraries at <b>org.apache.httpcomponents.client5</b>
         */
        public OrgApacheHttpcomponentsClient5LibraryAccessors getClient5() {
            return laccForOrgApacheHttpcomponentsClient5LibraryAccessors;
        }

    }

    public static class OrgApacheHttpcomponentsClient5LibraryAccessors extends SubDependencyFactory {

        public OrgApacheHttpcomponentsClient5LibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>httpclient5</b> with <b>org.apache.httpcomponents.client5:httpclient5</b> coordinates and
         * with version reference <b>org.apache.httpcomponents.client5.httpclient5</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getHttpclient5() {
            return create("org.apache.httpcomponents.client5.httpclient5");
        }

    }

    public static class OrgApacheMavenLibraryAccessors extends SubDependencyFactory {
        private final OrgApacheMavenMavenLibraryAccessors laccForOrgApacheMavenMavenLibraryAccessors = new OrgApacheMavenMavenLibraryAccessors(owner);
        private final OrgApacheMavenPluginLibraryAccessors laccForOrgApacheMavenPluginLibraryAccessors = new OrgApacheMavenPluginLibraryAccessors(owner);

        public OrgApacheMavenLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.apache.maven.maven</b>
         */
        public OrgApacheMavenMavenLibraryAccessors getMaven() {
            return laccForOrgApacheMavenMavenLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.apache.maven.plugin</b>
         */
        public OrgApacheMavenPluginLibraryAccessors getPlugin() {
            return laccForOrgApacheMavenPluginLibraryAccessors;
        }

    }

    public static class OrgApacheMavenMavenLibraryAccessors extends SubDependencyFactory {
        private final OrgApacheMavenMavenPluginLibraryAccessors laccForOrgApacheMavenMavenPluginLibraryAccessors = new OrgApacheMavenMavenPluginLibraryAccessors(owner);

        public OrgApacheMavenMavenLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>project</b> with <b>org.apache.maven:maven-project</b> coordinates and
         * with version reference <b>org.apache.maven.maven.project</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getProject() {
            return create("org.apache.maven.maven.project");
        }

        /**
         * Group of libraries at <b>org.apache.maven.maven.plugin</b>
         */
        public OrgApacheMavenMavenPluginLibraryAccessors getPlugin() {
            return laccForOrgApacheMavenMavenPluginLibraryAccessors;
        }

    }

    public static class OrgApacheMavenMavenPluginLibraryAccessors extends SubDependencyFactory {

        public OrgApacheMavenMavenPluginLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>api</b> with <b>org.apache.maven:maven-plugin-api</b> coordinates and
         * with version reference <b>org.apache.maven.maven.plugin.api</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getApi() {
            return create("org.apache.maven.maven.plugin.api");
        }

    }

    public static class OrgApacheMavenPluginLibraryAccessors extends SubDependencyFactory {
        private final OrgApacheMavenPluginToolsLibraryAccessors laccForOrgApacheMavenPluginToolsLibraryAccessors = new OrgApacheMavenPluginToolsLibraryAccessors(owner);

        public OrgApacheMavenPluginLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.apache.maven.plugin.tools</b>
         */
        public OrgApacheMavenPluginToolsLibraryAccessors getTools() {
            return laccForOrgApacheMavenPluginToolsLibraryAccessors;
        }

    }

    public static class OrgApacheMavenPluginToolsLibraryAccessors extends SubDependencyFactory {
        private final OrgApacheMavenPluginToolsMavenLibraryAccessors laccForOrgApacheMavenPluginToolsMavenLibraryAccessors = new OrgApacheMavenPluginToolsMavenLibraryAccessors(owner);

        public OrgApacheMavenPluginToolsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.apache.maven.plugin.tools.maven</b>
         */
        public OrgApacheMavenPluginToolsMavenLibraryAccessors getMaven() {
            return laccForOrgApacheMavenPluginToolsMavenLibraryAccessors;
        }

    }

    public static class OrgApacheMavenPluginToolsMavenLibraryAccessors extends SubDependencyFactory {
        private final OrgApacheMavenPluginToolsMavenPluginLibraryAccessors laccForOrgApacheMavenPluginToolsMavenPluginLibraryAccessors = new OrgApacheMavenPluginToolsMavenPluginLibraryAccessors(owner);

        public OrgApacheMavenPluginToolsMavenLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.apache.maven.plugin.tools.maven.plugin</b>
         */
        public OrgApacheMavenPluginToolsMavenPluginLibraryAccessors getPlugin() {
            return laccForOrgApacheMavenPluginToolsMavenPluginLibraryAccessors;
        }

    }

    public static class OrgApacheMavenPluginToolsMavenPluginLibraryAccessors extends SubDependencyFactory {

        public OrgApacheMavenPluginToolsMavenPluginLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>annotations</b> with <b>org.apache.maven.plugin-tools:maven-plugin-annotations</b> coordinates and
         * with version reference <b>org.apache.maven.plugin.tools.maven.plugin.annotations</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getAnnotations() {
            return create("org.apache.maven.plugin.tools.maven.plugin.annotations");
        }

    }

    public static class OrgApachePoiLibraryAccessors extends SubDependencyFactory {
        private final OrgApachePoiPoiLibraryAccessors laccForOrgApachePoiPoiLibraryAccessors = new OrgApachePoiPoiLibraryAccessors(owner);

        public OrgApachePoiLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.apache.poi.poi</b>
         */
        public OrgApachePoiPoiLibraryAccessors getPoi() {
            return laccForOrgApachePoiPoiLibraryAccessors;
        }

    }

    public static class OrgApachePoiPoiLibraryAccessors extends SubDependencyFactory {

        public OrgApachePoiPoiLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>ooxml</b> with <b>org.apache.poi:poi-ooxml</b> coordinates and
         * with version reference <b>org.apache.poi.poi.ooxml</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getOoxml() {
            return create("org.apache.poi.poi.ooxml");
        }

    }

    public static class OrgApacheTikaLibraryAccessors extends SubDependencyFactory {
        private final OrgApacheTikaTikaLibraryAccessors laccForOrgApacheTikaTikaLibraryAccessors = new OrgApacheTikaTikaLibraryAccessors(owner);

        public OrgApacheTikaLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.apache.tika.tika</b>
         */
        public OrgApacheTikaTikaLibraryAccessors getTika() {
            return laccForOrgApacheTikaTikaLibraryAccessors;
        }

    }

    public static class OrgApacheTikaTikaLibraryAccessors extends SubDependencyFactory {

        public OrgApacheTikaTikaLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>core</b> with <b>org.apache.tika:tika-core</b> coordinates and
         * with version reference <b>org.apache.tika.tika.core</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getCore() {
            return create("org.apache.tika.tika.core");
        }

    }

    public static class OrgEclipseLibraryAccessors extends SubDependencyFactory {
        private final OrgEclipseDigitaltwinLibraryAccessors laccForOrgEclipseDigitaltwinLibraryAccessors = new OrgEclipseDigitaltwinLibraryAccessors(owner);
        private final OrgEclipsePahoLibraryAccessors laccForOrgEclipsePahoLibraryAccessors = new OrgEclipsePahoLibraryAccessors(owner);

        public OrgEclipseLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.eclipse.digitaltwin</b>
         */
        public OrgEclipseDigitaltwinLibraryAccessors getDigitaltwin() {
            return laccForOrgEclipseDigitaltwinLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.eclipse.paho</b>
         */
        public OrgEclipsePahoLibraryAccessors getPaho() {
            return laccForOrgEclipsePahoLibraryAccessors;
        }

    }

    public static class OrgEclipseDigitaltwinLibraryAccessors extends SubDependencyFactory {
        private final OrgEclipseDigitaltwinAas4jLibraryAccessors laccForOrgEclipseDigitaltwinAas4jLibraryAccessors = new OrgEclipseDigitaltwinAas4jLibraryAccessors(owner);

        public OrgEclipseDigitaltwinLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.eclipse.digitaltwin.aas4j</b>
         */
        public OrgEclipseDigitaltwinAas4jLibraryAccessors getAas4j() {
            return laccForOrgEclipseDigitaltwinAas4jLibraryAccessors;
        }

    }

    public static class OrgEclipseDigitaltwinAas4jLibraryAccessors extends SubDependencyFactory {
        private final OrgEclipseDigitaltwinAas4jAas4jLibraryAccessors laccForOrgEclipseDigitaltwinAas4jAas4jLibraryAccessors = new OrgEclipseDigitaltwinAas4jAas4jLibraryAccessors(owner);

        public OrgEclipseDigitaltwinAas4jLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.eclipse.digitaltwin.aas4j.aas4j</b>
         */
        public OrgEclipseDigitaltwinAas4jAas4jLibraryAccessors getAas4j() {
            return laccForOrgEclipseDigitaltwinAas4jAas4jLibraryAccessors;
        }

    }

    public static class OrgEclipseDigitaltwinAas4jAas4jLibraryAccessors extends SubDependencyFactory {
        private final OrgEclipseDigitaltwinAas4jAas4jDataformatLibraryAccessors laccForOrgEclipseDigitaltwinAas4jAas4jDataformatLibraryAccessors = new OrgEclipseDigitaltwinAas4jAas4jDataformatLibraryAccessors(owner);

        public OrgEclipseDigitaltwinAas4jAas4jLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>model</b> with <b>org.eclipse.digitaltwin.aas4j:aas4j-model</b> coordinates and
         * with version reference <b>org.eclipse.digitaltwin.aas4j.aas4j.model</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getModel() {
            return create("org.eclipse.digitaltwin.aas4j.aas4j.model");
        }

        /**
         * Group of libraries at <b>org.eclipse.digitaltwin.aas4j.aas4j.dataformat</b>
         */
        public OrgEclipseDigitaltwinAas4jAas4jDataformatLibraryAccessors getDataformat() {
            return laccForOrgEclipseDigitaltwinAas4jAas4jDataformatLibraryAccessors;
        }

    }

    public static class OrgEclipseDigitaltwinAas4jAas4jDataformatLibraryAccessors extends SubDependencyFactory {

        public OrgEclipseDigitaltwinAas4jAas4jDataformatLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>aasx</b> with <b>org.eclipse.digitaltwin.aas4j:aas4j-dataformat-aasx</b> coordinates and
         * with version reference <b>org.eclipse.digitaltwin.aas4j.aas4j.dataformat.aasx</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getAasx() {
            return create("org.eclipse.digitaltwin.aas4j.aas4j.dataformat.aasx");
        }

        /**
         * Dependency provider for <b>core</b> with <b>org.eclipse.digitaltwin.aas4j:aas4j-dataformat-core</b> coordinates and
         * with version reference <b>org.eclipse.digitaltwin.aas4j.aas4j.dataformat.core</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getCore() {
            return create("org.eclipse.digitaltwin.aas4j.aas4j.dataformat.core");
        }

        /**
         * Dependency provider for <b>json</b> with <b>org.eclipse.digitaltwin.aas4j:aas4j-dataformat-json</b> coordinates and
         * with version reference <b>org.eclipse.digitaltwin.aas4j.aas4j.dataformat.json</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJson() {
            return create("org.eclipse.digitaltwin.aas4j.aas4j.dataformat.json");
        }

        /**
         * Dependency provider for <b>xml</b> with <b>org.eclipse.digitaltwin.aas4j:aas4j-dataformat-xml</b> coordinates and
         * with version reference <b>org.eclipse.digitaltwin.aas4j.aas4j.dataformat.xml</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getXml() {
            return create("org.eclipse.digitaltwin.aas4j.aas4j.dataformat.xml");
        }

    }

    public static class OrgEclipsePahoLibraryAccessors extends SubDependencyFactory {
        private final OrgEclipsePahoOrgLibraryAccessors laccForOrgEclipsePahoOrgLibraryAccessors = new OrgEclipsePahoOrgLibraryAccessors(owner);

        public OrgEclipsePahoLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.eclipse.paho.org</b>
         */
        public OrgEclipsePahoOrgLibraryAccessors getOrg() {
            return laccForOrgEclipsePahoOrgLibraryAccessors;
        }

    }

    public static class OrgEclipsePahoOrgLibraryAccessors extends SubDependencyFactory {
        private final OrgEclipsePahoOrgEclipseLibraryAccessors laccForOrgEclipsePahoOrgEclipseLibraryAccessors = new OrgEclipsePahoOrgEclipseLibraryAccessors(owner);

        public OrgEclipsePahoOrgLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.eclipse.paho.org.eclipse</b>
         */
        public OrgEclipsePahoOrgEclipseLibraryAccessors getEclipse() {
            return laccForOrgEclipsePahoOrgEclipseLibraryAccessors;
        }

    }

    public static class OrgEclipsePahoOrgEclipseLibraryAccessors extends SubDependencyFactory {
        private final OrgEclipsePahoOrgEclipsePahoLibraryAccessors laccForOrgEclipsePahoOrgEclipsePahoLibraryAccessors = new OrgEclipsePahoOrgEclipsePahoLibraryAccessors(owner);

        public OrgEclipsePahoOrgEclipseLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.eclipse.paho.org.eclipse.paho</b>
         */
        public OrgEclipsePahoOrgEclipsePahoLibraryAccessors getPaho() {
            return laccForOrgEclipsePahoOrgEclipsePahoLibraryAccessors;
        }

    }

    public static class OrgEclipsePahoOrgEclipsePahoLibraryAccessors extends SubDependencyFactory {
        private final OrgEclipsePahoOrgEclipsePahoClientLibraryAccessors laccForOrgEclipsePahoOrgEclipsePahoClientLibraryAccessors = new OrgEclipsePahoOrgEclipsePahoClientLibraryAccessors(owner);

        public OrgEclipsePahoOrgEclipsePahoLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.eclipse.paho.org.eclipse.paho.client</b>
         */
        public OrgEclipsePahoOrgEclipsePahoClientLibraryAccessors getClient() {
            return laccForOrgEclipsePahoOrgEclipsePahoClientLibraryAccessors;
        }

    }

    public static class OrgEclipsePahoOrgEclipsePahoClientLibraryAccessors extends SubDependencyFactory {

        public OrgEclipsePahoOrgEclipsePahoClientLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>mqttv3</b> with <b>org.eclipse.paho:org.eclipse.paho.client.mqttv3</b> coordinates and
         * with version reference <b>org.eclipse.paho.org.eclipse.paho.client.mqttv3</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getMqttv3() {
            return create("org.eclipse.paho.org.eclipse.paho.client.mqttv3");
        }

    }

    public static class OrgHibernateLibraryAccessors extends SubDependencyFactory {
        private final OrgHibernateValidatorLibraryAccessors laccForOrgHibernateValidatorLibraryAccessors = new OrgHibernateValidatorLibraryAccessors(owner);

        public OrgHibernateLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.hibernate.validator</b>
         */
        public OrgHibernateValidatorLibraryAccessors getValidator() {
            return laccForOrgHibernateValidatorLibraryAccessors;
        }

    }

    public static class OrgHibernateValidatorLibraryAccessors extends SubDependencyFactory {
        private final OrgHibernateValidatorHibernateLibraryAccessors laccForOrgHibernateValidatorHibernateLibraryAccessors = new OrgHibernateValidatorHibernateLibraryAccessors(owner);

        public OrgHibernateValidatorLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.hibernate.validator.hibernate</b>
         */
        public OrgHibernateValidatorHibernateLibraryAccessors getHibernate() {
            return laccForOrgHibernateValidatorHibernateLibraryAccessors;
        }

    }

    public static class OrgHibernateValidatorHibernateLibraryAccessors extends SubDependencyFactory {

        public OrgHibernateValidatorHibernateLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>validator</b> with <b>org.hibernate.validator:hibernate-validator</b> coordinates and
         * with version reference <b>org.hibernate.validator.hibernate.validator</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getValidator() {
            return create("org.hibernate.validator.hibernate.validator");
        }

    }

    public static class OrgJsonLibraryAccessors extends SubDependencyFactory {

        public OrgJsonLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>json</b> with <b>org.json:json</b> coordinates and
         * with version reference <b>org.json.json</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJson() {
            return create("org.json.json");
        }

    }

    public static class OrgJunitLibraryAccessors extends SubDependencyFactory {
        private final OrgJunitVintageLibraryAccessors laccForOrgJunitVintageLibraryAccessors = new OrgJunitVintageLibraryAccessors(owner);

        public OrgJunitLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.junit.vintage</b>
         */
        public OrgJunitVintageLibraryAccessors getVintage() {
            return laccForOrgJunitVintageLibraryAccessors;
        }

    }

    public static class OrgJunitVintageLibraryAccessors extends SubDependencyFactory {
        private final OrgJunitVintageJunitLibraryAccessors laccForOrgJunitVintageJunitLibraryAccessors = new OrgJunitVintageJunitLibraryAccessors(owner);

        public OrgJunitVintageLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.junit.vintage.junit</b>
         */
        public OrgJunitVintageJunitLibraryAccessors getJunit() {
            return laccForOrgJunitVintageJunitLibraryAccessors;
        }

    }

    public static class OrgJunitVintageJunitLibraryAccessors extends SubDependencyFactory {
        private final OrgJunitVintageJunitVintageLibraryAccessors laccForOrgJunitVintageJunitVintageLibraryAccessors = new OrgJunitVintageJunitVintageLibraryAccessors(owner);

        public OrgJunitVintageJunitLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.junit.vintage.junit.vintage</b>
         */
        public OrgJunitVintageJunitVintageLibraryAccessors getVintage() {
            return laccForOrgJunitVintageJunitVintageLibraryAccessors;
        }

    }

    public static class OrgJunitVintageJunitVintageLibraryAccessors extends SubDependencyFactory {

        public OrgJunitVintageJunitVintageLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>engine</b> with <b>org.junit.vintage:junit-vintage-engine</b> coordinates and
         * with version reference <b>org.junit.vintage.junit.vintage.engine</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getEngine() {
            return create("org.junit.vintage.junit.vintage.engine");
        }

    }

    public static class OrgMockLibraryAccessors extends SubDependencyFactory {
        private final OrgMockServerLibraryAccessors laccForOrgMockServerLibraryAccessors = new OrgMockServerLibraryAccessors(owner);

        public OrgMockLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.mock.server</b>
         */
        public OrgMockServerLibraryAccessors getServer() {
            return laccForOrgMockServerLibraryAccessors;
        }

    }

    public static class OrgMockServerLibraryAccessors extends SubDependencyFactory {
        private final OrgMockServerMockserverLibraryAccessors laccForOrgMockServerMockserverLibraryAccessors = new OrgMockServerMockserverLibraryAccessors(owner);

        public OrgMockServerLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.mock.server.mockserver</b>
         */
        public OrgMockServerMockserverLibraryAccessors getMockserver() {
            return laccForOrgMockServerMockserverLibraryAccessors;
        }

    }

    public static class OrgMockServerMockserverLibraryAccessors extends SubDependencyFactory {

        public OrgMockServerMockserverLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>netty</b> with <b>org.mock-server:mockserver-netty</b> coordinates and
         * with version reference <b>org.mock.server.mockserver.netty</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getNetty() {
            return create("org.mock.server.mockserver.netty");
        }

    }

    public static class OrgMockitoLibraryAccessors extends SubDependencyFactory {
        private final OrgMockitoMockitoLibraryAccessors laccForOrgMockitoMockitoLibraryAccessors = new OrgMockitoMockitoLibraryAccessors(owner);

        public OrgMockitoLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.mockito.mockito</b>
         */
        public OrgMockitoMockitoLibraryAccessors getMockito() {
            return laccForOrgMockitoMockitoLibraryAccessors;
        }

    }

    public static class OrgMockitoMockitoLibraryAccessors extends SubDependencyFactory {

        public OrgMockitoMockitoLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>core</b> with <b>org.mockito:mockito-core</b> coordinates and
         * with version reference <b>org.mockito.mockito.core</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getCore() {
            return create("org.mockito.mockito.core");
        }

    }

    public static class OrgOpenapitoolsLibraryAccessors extends SubDependencyFactory {
        private final OrgOpenapitoolsJacksonLibraryAccessors laccForOrgOpenapitoolsJacksonLibraryAccessors = new OrgOpenapitoolsJacksonLibraryAccessors(owner);

        public OrgOpenapitoolsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.openapitools.jackson</b>
         */
        public OrgOpenapitoolsJacksonLibraryAccessors getJackson() {
            return laccForOrgOpenapitoolsJacksonLibraryAccessors;
        }

    }

    public static class OrgOpenapitoolsJacksonLibraryAccessors extends SubDependencyFactory {
        private final OrgOpenapitoolsJacksonDatabindLibraryAccessors laccForOrgOpenapitoolsJacksonDatabindLibraryAccessors = new OrgOpenapitoolsJacksonDatabindLibraryAccessors(owner);

        public OrgOpenapitoolsJacksonLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.openapitools.jackson.databind</b>
         */
        public OrgOpenapitoolsJacksonDatabindLibraryAccessors getDatabind() {
            return laccForOrgOpenapitoolsJacksonDatabindLibraryAccessors;
        }

    }

    public static class OrgOpenapitoolsJacksonDatabindLibraryAccessors extends SubDependencyFactory {

        public OrgOpenapitoolsJacksonDatabindLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>nullable</b> with <b>org.openapitools:jackson-databind-nullable</b> coordinates and
         * with version reference <b>org.openapitools.jackson.databind.nullable</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getNullable() {
            return create("org.openapitools.jackson.databind.nullable");
        }

    }

    public static class OrgProjectlombokLibraryAccessors extends SubDependencyFactory {

        public OrgProjectlombokLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>lombok</b> with <b>org.projectlombok:lombok</b> coordinates and
         * with version reference <b>org.projectlombok.lombok</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getLombok() {
            return create("org.projectlombok.lombok");
        }

    }

    public static class OrgReflectionsLibraryAccessors extends SubDependencyFactory {

        public OrgReflectionsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>reflections</b> with <b>org.reflections:reflections</b> coordinates and
         * with version reference <b>org.reflections.reflections</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getReflections() {
            return create("org.reflections.reflections");
        }

    }

    public static class OrgSlf4jLibraryAccessors extends SubDependencyFactory {
        private final OrgSlf4jSlf4jLibraryAccessors laccForOrgSlf4jSlf4jLibraryAccessors = new OrgSlf4jSlf4jLibraryAccessors(owner);

        public OrgSlf4jLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.slf4j.slf4j</b>
         */
        public OrgSlf4jSlf4jLibraryAccessors getSlf4j() {
            return laccForOrgSlf4jSlf4jLibraryAccessors;
        }

    }

    public static class OrgSlf4jSlf4jLibraryAccessors extends SubDependencyFactory {

        public OrgSlf4jSlf4jLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>api</b> with <b>org.slf4j:slf4j-api</b> coordinates and
         * with version reference <b>org.slf4j.slf4j.api</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getApi() {
            return create("org.slf4j.slf4j.api");
        }

        /**
         * Dependency provider for <b>simple</b> with <b>org.slf4j:slf4j-simple</b> coordinates and
         * with version reference <b>org.slf4j.slf4j.simple</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getSimple() {
            return create("org.slf4j.slf4j.simple");
        }

    }

    public static class OrgSpringdocLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringdocSpringdocLibraryAccessors laccForOrgSpringdocSpringdocLibraryAccessors = new OrgSpringdocSpringdocLibraryAccessors(owner);

        public OrgSpringdocLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.springdoc.springdoc</b>
         */
        public OrgSpringdocSpringdocLibraryAccessors getSpringdoc() {
            return laccForOrgSpringdocSpringdocLibraryAccessors;
        }

    }

    public static class OrgSpringdocSpringdocLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringdocSpringdocOpenapiLibraryAccessors laccForOrgSpringdocSpringdocOpenapiLibraryAccessors = new OrgSpringdocSpringdocOpenapiLibraryAccessors(owner);

        public OrgSpringdocSpringdocLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.springdoc.springdoc.openapi</b>
         */
        public OrgSpringdocSpringdocOpenapiLibraryAccessors getOpenapi() {
            return laccForOrgSpringdocSpringdocOpenapiLibraryAccessors;
        }

    }

    public static class OrgSpringdocSpringdocOpenapiLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringdocSpringdocOpenapiStarterLibraryAccessors laccForOrgSpringdocSpringdocOpenapiStarterLibraryAccessors = new OrgSpringdocSpringdocOpenapiStarterLibraryAccessors(owner);

        public OrgSpringdocSpringdocOpenapiLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.springdoc.springdoc.openapi.starter</b>
         */
        public OrgSpringdocSpringdocOpenapiStarterLibraryAccessors getStarter() {
            return laccForOrgSpringdocSpringdocOpenapiStarterLibraryAccessors;
        }

    }

    public static class OrgSpringdocSpringdocOpenapiStarterLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringdocSpringdocOpenapiStarterWebmvcLibraryAccessors laccForOrgSpringdocSpringdocOpenapiStarterWebmvcLibraryAccessors = new OrgSpringdocSpringdocOpenapiStarterWebmvcLibraryAccessors(owner);

        public OrgSpringdocSpringdocOpenapiStarterLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.springdoc.springdoc.openapi.starter.webmvc</b>
         */
        public OrgSpringdocSpringdocOpenapiStarterWebmvcLibraryAccessors getWebmvc() {
            return laccForOrgSpringdocSpringdocOpenapiStarterWebmvcLibraryAccessors;
        }

    }

    public static class OrgSpringdocSpringdocOpenapiStarterWebmvcLibraryAccessors extends SubDependencyFactory {

        public OrgSpringdocSpringdocOpenapiStarterWebmvcLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>ui</b> with <b>org.springdoc:springdoc-openapi-starter-webmvc-ui</b> coordinates and
         * with version reference <b>org.springdoc.springdoc.openapi.starter.webmvc.ui</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getUi() {
            return create("org.springdoc.springdoc.openapi.starter.webmvc.ui");
        }

    }

    public static class OrgSpringframeworkLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringframeworkBootLibraryAccessors laccForOrgSpringframeworkBootLibraryAccessors = new OrgSpringframeworkBootLibraryAccessors(owner);
        private final OrgSpringframeworkCloudLibraryAccessors laccForOrgSpringframeworkCloudLibraryAccessors = new OrgSpringframeworkCloudLibraryAccessors(owner);
        private final OrgSpringframeworkDataLibraryAccessors laccForOrgSpringframeworkDataLibraryAccessors = new OrgSpringframeworkDataLibraryAccessors(owner);
        private final OrgSpringframeworkIntegrationLibraryAccessors laccForOrgSpringframeworkIntegrationLibraryAccessors = new OrgSpringframeworkIntegrationLibraryAccessors(owner);
        private final OrgSpringframeworkKafkaLibraryAccessors laccForOrgSpringframeworkKafkaLibraryAccessors = new OrgSpringframeworkKafkaLibraryAccessors(owner);
        private final OrgSpringframeworkSpringLibraryAccessors laccForOrgSpringframeworkSpringLibraryAccessors = new OrgSpringframeworkSpringLibraryAccessors(owner);

        public OrgSpringframeworkLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.springframework.boot</b>
         */
        public OrgSpringframeworkBootLibraryAccessors getBoot() {
            return laccForOrgSpringframeworkBootLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.springframework.cloud</b>
         */
        public OrgSpringframeworkCloudLibraryAccessors getCloud() {
            return laccForOrgSpringframeworkCloudLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.springframework.data</b>
         */
        public OrgSpringframeworkDataLibraryAccessors getData() {
            return laccForOrgSpringframeworkDataLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.springframework.integration</b>
         */
        public OrgSpringframeworkIntegrationLibraryAccessors getIntegration() {
            return laccForOrgSpringframeworkIntegrationLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.springframework.kafka</b>
         */
        public OrgSpringframeworkKafkaLibraryAccessors getKafka() {
            return laccForOrgSpringframeworkKafkaLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.springframework.spring</b>
         */
        public OrgSpringframeworkSpringLibraryAccessors getSpring() {
            return laccForOrgSpringframeworkSpringLibraryAccessors;
        }

    }

    public static class OrgSpringframeworkBootLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringframeworkBootSpringLibraryAccessors laccForOrgSpringframeworkBootSpringLibraryAccessors = new OrgSpringframeworkBootSpringLibraryAccessors(owner);

        public OrgSpringframeworkBootLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.springframework.boot.spring</b>
         */
        public OrgSpringframeworkBootSpringLibraryAccessors getSpring() {
            return laccForOrgSpringframeworkBootSpringLibraryAccessors;
        }

    }

    public static class OrgSpringframeworkBootSpringLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringframeworkBootSpringBootLibraryAccessors laccForOrgSpringframeworkBootSpringBootLibraryAccessors = new OrgSpringframeworkBootSpringBootLibraryAccessors(owner);

        public OrgSpringframeworkBootSpringLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.springframework.boot.spring.boot</b>
         */
        public OrgSpringframeworkBootSpringBootLibraryAccessors getBoot() {
            return laccForOrgSpringframeworkBootSpringBootLibraryAccessors;
        }

    }

    public static class OrgSpringframeworkBootSpringBootLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringframeworkBootSpringBootActuatorLibraryAccessors laccForOrgSpringframeworkBootSpringBootActuatorLibraryAccessors = new OrgSpringframeworkBootSpringBootActuatorLibraryAccessors(owner);
        private final OrgSpringframeworkBootSpringBootConfigurationLibraryAccessors laccForOrgSpringframeworkBootSpringBootConfigurationLibraryAccessors = new OrgSpringframeworkBootSpringBootConfigurationLibraryAccessors(owner);
        private final OrgSpringframeworkBootSpringBootStarterLibraryAccessors laccForOrgSpringframeworkBootSpringBootStarterLibraryAccessors = new OrgSpringframeworkBootSpringBootStarterLibraryAccessors(owner);

        public OrgSpringframeworkBootSpringBootLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.springframework.boot.spring.boot.actuator</b>
         */
        public OrgSpringframeworkBootSpringBootActuatorLibraryAccessors getActuator() {
            return laccForOrgSpringframeworkBootSpringBootActuatorLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.springframework.boot.spring.boot.configuration</b>
         */
        public OrgSpringframeworkBootSpringBootConfigurationLibraryAccessors getConfiguration() {
            return laccForOrgSpringframeworkBootSpringBootConfigurationLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.springframework.boot.spring.boot.starter</b>
         */
        public OrgSpringframeworkBootSpringBootStarterLibraryAccessors getStarter() {
            return laccForOrgSpringframeworkBootSpringBootStarterLibraryAccessors;
        }

    }

    public static class OrgSpringframeworkBootSpringBootActuatorLibraryAccessors extends SubDependencyFactory {

        public OrgSpringframeworkBootSpringBootActuatorLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>autoconfigure</b> with <b>org.springframework.boot:spring-boot-actuator-autoconfigure</b> coordinates and
         * with version reference <b>org.springframework.boot.spring.boot.actuator.autoconfigure</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getAutoconfigure() {
            return create("org.springframework.boot.spring.boot.actuator.autoconfigure");
        }

    }

    public static class OrgSpringframeworkBootSpringBootConfigurationLibraryAccessors extends SubDependencyFactory {

        public OrgSpringframeworkBootSpringBootConfigurationLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>processor</b> with <b>org.springframework.boot:spring-boot-configuration-processor</b> coordinates and
         * with version reference <b>org.springframework.boot.spring.boot.configuration.processor</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getProcessor() {
            return create("org.springframework.boot.spring.boot.configuration.processor");
        }

    }

    public static class OrgSpringframeworkBootSpringBootStarterLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {
        private final OrgSpringframeworkBootSpringBootStarterDataLibraryAccessors laccForOrgSpringframeworkBootSpringBootStarterDataLibraryAccessors = new OrgSpringframeworkBootSpringBootStarterDataLibraryAccessors(owner);
        private final OrgSpringframeworkBootSpringBootStarterOauth2LibraryAccessors laccForOrgSpringframeworkBootSpringBootStarterOauth2LibraryAccessors = new OrgSpringframeworkBootSpringBootStarterOauth2LibraryAccessors(owner);

        public OrgSpringframeworkBootSpringBootStarterLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>starter</b> with <b>org.springframework.boot:spring-boot-starter</b> coordinates and
         * with version reference <b>org.springframework.boot.spring.boot.starter</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> asProvider() {
            return create("org.springframework.boot.spring.boot.starter");
        }

        /**
         * Dependency provider for <b>actuator</b> with <b>org.springframework.boot:spring-boot-starter-actuator</b> coordinates and
         * with version reference <b>org.springframework.boot.spring.boot.starter.actuator</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getActuator() {
            return create("org.springframework.boot.spring.boot.starter.actuator");
        }

        /**
         * Dependency provider for <b>security</b> with <b>org.springframework.boot:spring-boot-starter-security</b> coordinates and
         * with version reference <b>org.springframework.boot.spring.boot.starter.security</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getSecurity() {
            return create("org.springframework.boot.spring.boot.starter.security");
        }

        /**
         * Dependency provider for <b>test</b> with <b>org.springframework.boot:spring-boot-starter-test</b> coordinates and
         * with version reference <b>org.springframework.boot.spring.boot.starter.test</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getTest() {
            return create("org.springframework.boot.spring.boot.starter.test");
        }

        /**
         * Dependency provider for <b>tomcat</b> with <b>org.springframework.boot:spring-boot-starter-tomcat</b> coordinates and
         * with version reference <b>org.springframework.boot.spring.boot.starter.tomcat</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getTomcat() {
            return create("org.springframework.boot.spring.boot.starter.tomcat");
        }

        /**
         * Dependency provider for <b>validation</b> with <b>org.springframework.boot:spring-boot-starter-validation</b> coordinates and
         * with version reference <b>org.springframework.boot.spring.boot.starter.validation</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getValidation() {
            return create("org.springframework.boot.spring.boot.starter.validation");
        }

        /**
         * Dependency provider for <b>web</b> with <b>org.springframework.boot:spring-boot-starter-web</b> coordinates and
         * with version reference <b>org.springframework.boot.spring.boot.starter.web</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getWeb() {
            return create("org.springframework.boot.spring.boot.starter.web");
        }

        /**
         * Dependency provider for <b>webflux</b> with <b>org.springframework.boot:spring-boot-starter-webflux</b> coordinates and
         * with version reference <b>org.springframework.boot.spring.boot.starter.webflux</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getWebflux() {
            return create("org.springframework.boot.spring.boot.starter.webflux");
        }

        /**
         * Group of libraries at <b>org.springframework.boot.spring.boot.starter.data</b>
         */
        public OrgSpringframeworkBootSpringBootStarterDataLibraryAccessors getData() {
            return laccForOrgSpringframeworkBootSpringBootStarterDataLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.springframework.boot.spring.boot.starter.oauth2</b>
         */
        public OrgSpringframeworkBootSpringBootStarterOauth2LibraryAccessors getOauth2() {
            return laccForOrgSpringframeworkBootSpringBootStarterOauth2LibraryAccessors;
        }

    }

    public static class OrgSpringframeworkBootSpringBootStarterDataLibraryAccessors extends SubDependencyFactory {

        public OrgSpringframeworkBootSpringBootStarterDataLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>mongodb</b> with <b>org.springframework.boot:spring-boot-starter-data-mongodb</b> coordinates and
         * with version reference <b>org.springframework.boot.spring.boot.starter.data.mongodb</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getMongodb() {
            return create("org.springframework.boot.spring.boot.starter.data.mongodb");
        }

    }

    public static class OrgSpringframeworkBootSpringBootStarterOauth2LibraryAccessors extends SubDependencyFactory {
        private final OrgSpringframeworkBootSpringBootStarterOauth2ResourceLibraryAccessors laccForOrgSpringframeworkBootSpringBootStarterOauth2ResourceLibraryAccessors = new OrgSpringframeworkBootSpringBootStarterOauth2ResourceLibraryAccessors(owner);

        public OrgSpringframeworkBootSpringBootStarterOauth2LibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.springframework.boot.spring.boot.starter.oauth2.resource</b>
         */
        public OrgSpringframeworkBootSpringBootStarterOauth2ResourceLibraryAccessors getResource() {
            return laccForOrgSpringframeworkBootSpringBootStarterOauth2ResourceLibraryAccessors;
        }

    }

    public static class OrgSpringframeworkBootSpringBootStarterOauth2ResourceLibraryAccessors extends SubDependencyFactory {

        public OrgSpringframeworkBootSpringBootStarterOauth2ResourceLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>server</b> with <b>org.springframework.boot:spring-boot-starter-oauth2-resource-server</b> coordinates and
         * with version reference <b>org.springframework.boot.spring.boot.starter.oauth2.resource.server</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getServer() {
            return create("org.springframework.boot.spring.boot.starter.oauth2.resource.server");
        }

    }

    public static class OrgSpringframeworkCloudLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringframeworkCloudSpringLibraryAccessors laccForOrgSpringframeworkCloudSpringLibraryAccessors = new OrgSpringframeworkCloudSpringLibraryAccessors(owner);

        public OrgSpringframeworkCloudLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.springframework.cloud.spring</b>
         */
        public OrgSpringframeworkCloudSpringLibraryAccessors getSpring() {
            return laccForOrgSpringframeworkCloudSpringLibraryAccessors;
        }

    }

    public static class OrgSpringframeworkCloudSpringLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringframeworkCloudSpringCloudLibraryAccessors laccForOrgSpringframeworkCloudSpringCloudLibraryAccessors = new OrgSpringframeworkCloudSpringCloudLibraryAccessors(owner);

        public OrgSpringframeworkCloudSpringLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.springframework.cloud.spring.cloud</b>
         */
        public OrgSpringframeworkCloudSpringCloudLibraryAccessors getCloud() {
            return laccForOrgSpringframeworkCloudSpringCloudLibraryAccessors;
        }

    }

    public static class OrgSpringframeworkCloudSpringCloudLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringframeworkCloudSpringCloudFunctionLibraryAccessors laccForOrgSpringframeworkCloudSpringCloudFunctionLibraryAccessors = new OrgSpringframeworkCloudSpringCloudFunctionLibraryAccessors(owner);

        public OrgSpringframeworkCloudSpringCloudLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.springframework.cloud.spring.cloud.function</b>
         */
        public OrgSpringframeworkCloudSpringCloudFunctionLibraryAccessors getFunction() {
            return laccForOrgSpringframeworkCloudSpringCloudFunctionLibraryAccessors;
        }

    }

    public static class OrgSpringframeworkCloudSpringCloudFunctionLibraryAccessors extends SubDependencyFactory {

        public OrgSpringframeworkCloudSpringCloudFunctionLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>context</b> with <b>org.springframework.cloud:spring-cloud-function-context</b> coordinates and
         * with version reference <b>org.springframework.cloud.spring.cloud.function.context</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getContext() {
            return create("org.springframework.cloud.spring.cloud.function.context");
        }

    }

    public static class OrgSpringframeworkDataLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringframeworkDataSpringLibraryAccessors laccForOrgSpringframeworkDataSpringLibraryAccessors = new OrgSpringframeworkDataSpringLibraryAccessors(owner);

        public OrgSpringframeworkDataLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.springframework.data.spring</b>
         */
        public OrgSpringframeworkDataSpringLibraryAccessors getSpring() {
            return laccForOrgSpringframeworkDataSpringLibraryAccessors;
        }

    }

    public static class OrgSpringframeworkDataSpringLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringframeworkDataSpringDataLibraryAccessors laccForOrgSpringframeworkDataSpringDataLibraryAccessors = new OrgSpringframeworkDataSpringDataLibraryAccessors(owner);

        public OrgSpringframeworkDataSpringLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.springframework.data.spring.data</b>
         */
        public OrgSpringframeworkDataSpringDataLibraryAccessors getData() {
            return laccForOrgSpringframeworkDataSpringDataLibraryAccessors;
        }

    }

    public static class OrgSpringframeworkDataSpringDataLibraryAccessors extends SubDependencyFactory {

        public OrgSpringframeworkDataSpringDataLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>commons</b> with <b>org.springframework.data:spring-data-commons</b> coordinates and
         * with version reference <b>org.springframework.data.spring.data.commons</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getCommons() {
            return create("org.springframework.data.spring.data.commons");
        }

    }

    public static class OrgSpringframeworkIntegrationLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringframeworkIntegrationSpringLibraryAccessors laccForOrgSpringframeworkIntegrationSpringLibraryAccessors = new OrgSpringframeworkIntegrationSpringLibraryAccessors(owner);

        public OrgSpringframeworkIntegrationLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.springframework.integration.spring</b>
         */
        public OrgSpringframeworkIntegrationSpringLibraryAccessors getSpring() {
            return laccForOrgSpringframeworkIntegrationSpringLibraryAccessors;
        }

    }

    public static class OrgSpringframeworkIntegrationSpringLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringframeworkIntegrationSpringIntegrationLibraryAccessors laccForOrgSpringframeworkIntegrationSpringIntegrationLibraryAccessors = new OrgSpringframeworkIntegrationSpringIntegrationLibraryAccessors(owner);

        public OrgSpringframeworkIntegrationSpringLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.springframework.integration.spring.integration</b>
         */
        public OrgSpringframeworkIntegrationSpringIntegrationLibraryAccessors getIntegration() {
            return laccForOrgSpringframeworkIntegrationSpringIntegrationLibraryAccessors;
        }

    }

    public static class OrgSpringframeworkIntegrationSpringIntegrationLibraryAccessors extends SubDependencyFactory {

        public OrgSpringframeworkIntegrationSpringIntegrationLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>file</b> with <b>org.springframework.integration:spring-integration-file</b> coordinates and
         * with version reference <b>org.springframework.integration.spring.integration.file</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getFile() {
            return create("org.springframework.integration.spring.integration.file");
        }

    }

    public static class OrgSpringframeworkKafkaLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringframeworkKafkaSpringLibraryAccessors laccForOrgSpringframeworkKafkaSpringLibraryAccessors = new OrgSpringframeworkKafkaSpringLibraryAccessors(owner);

        public OrgSpringframeworkKafkaLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.springframework.kafka.spring</b>
         */
        public OrgSpringframeworkKafkaSpringLibraryAccessors getSpring() {
            return laccForOrgSpringframeworkKafkaSpringLibraryAccessors;
        }

    }

    public static class OrgSpringframeworkKafkaSpringLibraryAccessors extends SubDependencyFactory {

        public OrgSpringframeworkKafkaSpringLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>kafka</b> with <b>org.springframework.kafka:spring-kafka</b> coordinates and
         * with version reference <b>org.springframework.kafka.spring.kafka</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getKafka() {
            return create("org.springframework.kafka.spring.kafka");
        }

    }

    public static class OrgSpringframeworkSpringLibraryAccessors extends SubDependencyFactory {

        public OrgSpringframeworkSpringLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>context</b> with <b>org.springframework:spring-context</b> coordinates and
         * with version reference <b>org.springframework.spring.context</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getContext() {
            return create("org.springframework.spring.context");
        }

        /**
         * Dependency provider for <b>web</b> with <b>org.springframework:spring-web</b> coordinates and
         * with version reference <b>org.springframework.spring.web</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getWeb() {
            return create("org.springframework.spring.web");
        }

    }

    public static class OrgXmlunitLibraryAccessors extends SubDependencyFactory {
        private final OrgXmlunitXmlunitLibraryAccessors laccForOrgXmlunitXmlunitLibraryAccessors = new OrgXmlunitXmlunitLibraryAccessors(owner);

        public OrgXmlunitLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.xmlunit.xmlunit</b>
         */
        public OrgXmlunitXmlunitLibraryAccessors getXmlunit() {
            return laccForOrgXmlunitXmlunitLibraryAccessors;
        }

    }

    public static class OrgXmlunitXmlunitLibraryAccessors extends SubDependencyFactory {

        public OrgXmlunitXmlunitLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>core</b> with <b>org.xmlunit:xmlunit-core</b> coordinates and
         * with version reference <b>org.xmlunit.xmlunit.core</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getCore() {
            return create("org.xmlunit.xmlunit.core");
        }

        /**
         * Dependency provider for <b>matchers</b> with <b>org.xmlunit:xmlunit-matchers</b> coordinates and
         * with version reference <b>org.xmlunit.xmlunit.matchers</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getMatchers() {
            return create("org.xmlunit.xmlunit.matchers");
        }

    }

    public static class OrgYamlLibraryAccessors extends SubDependencyFactory {

        public OrgYamlLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>snakeyaml</b> with <b>org.yaml:snakeyaml</b> coordinates and
         * with version reference <b>org.yaml.snakeyaml</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getSnakeyaml() {
            return create("org.yaml.snakeyaml");
        }

    }

    public static class VersionAccessors extends VersionFactory  {

        private final ComVersionAccessors vaccForComVersionAccessors = new ComVersionAccessors(providers, config);
        private final CommonsVersionAccessors vaccForCommonsVersionAccessors = new CommonsVersionAccessors(providers, config);
        private final IoVersionAccessors vaccForIoVersionAccessors = new IoVersionAccessors(providers, config);
        private final JakartaVersionAccessors vaccForJakartaVersionAccessors = new JakartaVersionAccessors(providers, config);
        private final OrgVersionAccessors vaccForOrgVersionAccessors = new OrgVersionAccessors(providers, config);
        public VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.com</b>
         */
        public ComVersionAccessors getCom() {
            return vaccForComVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.commons</b>
         */
        public CommonsVersionAccessors getCommons() {
            return vaccForCommonsVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.io</b>
         */
        public IoVersionAccessors getIo() {
            return vaccForIoVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.jakarta</b>
         */
        public JakartaVersionAccessors getJakarta() {
            return vaccForJakartaVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.org</b>
         */
        public OrgVersionAccessors getOrg() {
            return vaccForOrgVersionAccessors;
        }

    }

    public static class ComVersionAccessors extends VersionFactory  {

        private final ComFasterxmlVersionAccessors vaccForComFasterxmlVersionAccessors = new ComFasterxmlVersionAccessors(providers, config);
        private final ComGithubVersionAccessors vaccForComGithubVersionAccessors = new ComGithubVersionAccessors(providers, config);
        private final ComGoogleVersionAccessors vaccForComGoogleVersionAccessors = new ComGoogleVersionAccessors(providers, config);
        private final ComNimbusdsVersionAccessors vaccForComNimbusdsVersionAccessors = new ComNimbusdsVersionAccessors(providers, config);
        public ComVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.com.fasterxml</b>
         */
        public ComFasterxmlVersionAccessors getFasterxml() {
            return vaccForComFasterxmlVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.com.github</b>
         */
        public ComGithubVersionAccessors getGithub() {
            return vaccForComGithubVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.com.google</b>
         */
        public ComGoogleVersionAccessors getGoogle() {
            return vaccForComGoogleVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.com.nimbusds</b>
         */
        public ComNimbusdsVersionAccessors getNimbusds() {
            return vaccForComNimbusdsVersionAccessors;
        }

    }

    public static class ComFasterxmlVersionAccessors extends VersionFactory  {

        private final ComFasterxmlJacksonVersionAccessors vaccForComFasterxmlJacksonVersionAccessors = new ComFasterxmlJacksonVersionAccessors(providers, config);
        public ComFasterxmlVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.com.fasterxml.jackson</b>
         */
        public ComFasterxmlJacksonVersionAccessors getJackson() {
            return vaccForComFasterxmlJacksonVersionAccessors;
        }

    }

    public static class ComFasterxmlJacksonVersionAccessors extends VersionFactory  {

        private final ComFasterxmlJacksonCoreVersionAccessors vaccForComFasterxmlJacksonCoreVersionAccessors = new ComFasterxmlJacksonCoreVersionAccessors(providers, config);
        private final ComFasterxmlJacksonDatatypeVersionAccessors vaccForComFasterxmlJacksonDatatypeVersionAccessors = new ComFasterxmlJacksonDatatypeVersionAccessors(providers, config);
        public ComFasterxmlJacksonVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.com.fasterxml.jackson.core</b>
         */
        public ComFasterxmlJacksonCoreVersionAccessors getCore() {
            return vaccForComFasterxmlJacksonCoreVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.com.fasterxml.jackson.datatype</b>
         */
        public ComFasterxmlJacksonDatatypeVersionAccessors getDatatype() {
            return vaccForComFasterxmlJacksonDatatypeVersionAccessors;
        }

    }

    public static class ComFasterxmlJacksonCoreVersionAccessors extends VersionFactory  {

        private final ComFasterxmlJacksonCoreJacksonVersionAccessors vaccForComFasterxmlJacksonCoreJacksonVersionAccessors = new ComFasterxmlJacksonCoreJacksonVersionAccessors(providers, config);
        public ComFasterxmlJacksonCoreVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.com.fasterxml.jackson.core.jackson</b>
         */
        public ComFasterxmlJacksonCoreJacksonVersionAccessors getJackson() {
            return vaccForComFasterxmlJacksonCoreJacksonVersionAccessors;
        }

    }

    public static class ComFasterxmlJacksonCoreJacksonVersionAccessors extends VersionFactory  {

        public ComFasterxmlJacksonCoreJacksonVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>com.fasterxml.jackson.core.jackson.annotations</b> with value <b>2.15.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getAnnotations() { return getVersion("com.fasterxml.jackson.core.jackson.annotations"); }

        /**
         * Version alias <b>com.fasterxml.jackson.core.jackson.core</b> with value <b>2.15.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getCore() { return getVersion("com.fasterxml.jackson.core.jackson.core"); }

        /**
         * Version alias <b>com.fasterxml.jackson.core.jackson.databind</b> with value <b>2.15.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getDatabind() { return getVersion("com.fasterxml.jackson.core.jackson.databind"); }

    }

    public static class ComFasterxmlJacksonDatatypeVersionAccessors extends VersionFactory  {

        private final ComFasterxmlJacksonDatatypeJacksonVersionAccessors vaccForComFasterxmlJacksonDatatypeJacksonVersionAccessors = new ComFasterxmlJacksonDatatypeJacksonVersionAccessors(providers, config);
        public ComFasterxmlJacksonDatatypeVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.com.fasterxml.jackson.datatype.jackson</b>
         */
        public ComFasterxmlJacksonDatatypeJacksonVersionAccessors getJackson() {
            return vaccForComFasterxmlJacksonDatatypeJacksonVersionAccessors;
        }

    }

    public static class ComFasterxmlJacksonDatatypeJacksonVersionAccessors extends VersionFactory  {

        private final ComFasterxmlJacksonDatatypeJacksonDatatypeVersionAccessors vaccForComFasterxmlJacksonDatatypeJacksonDatatypeVersionAccessors = new ComFasterxmlJacksonDatatypeJacksonDatatypeVersionAccessors(providers, config);
        public ComFasterxmlJacksonDatatypeJacksonVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.com.fasterxml.jackson.datatype.jackson.datatype</b>
         */
        public ComFasterxmlJacksonDatatypeJacksonDatatypeVersionAccessors getDatatype() {
            return vaccForComFasterxmlJacksonDatatypeJacksonDatatypeVersionAccessors;
        }

    }

    public static class ComFasterxmlJacksonDatatypeJacksonDatatypeVersionAccessors extends VersionFactory  {

        public ComFasterxmlJacksonDatatypeJacksonDatatypeVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>com.fasterxml.jackson.datatype.jackson.datatype.jsr310</b> with value <b>2.15.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getJsr310() { return getVersion("com.fasterxml.jackson.datatype.jackson.datatype.jsr310"); }

    }

    public static class ComGithubVersionAccessors extends VersionFactory  {

        private final ComGithubSpullaraVersionAccessors vaccForComGithubSpullaraVersionAccessors = new ComGithubSpullaraVersionAccessors(providers, config);
        public ComGithubVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.com.github.spullara</b>
         */
        public ComGithubSpullaraVersionAccessors getSpullara() {
            return vaccForComGithubSpullaraVersionAccessors;
        }

    }

    public static class ComGithubSpullaraVersionAccessors extends VersionFactory  {

        private final ComGithubSpullaraMustacheVersionAccessors vaccForComGithubSpullaraMustacheVersionAccessors = new ComGithubSpullaraMustacheVersionAccessors(providers, config);
        public ComGithubSpullaraVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.com.github.spullara.mustache</b>
         */
        public ComGithubSpullaraMustacheVersionAccessors getMustache() {
            return vaccForComGithubSpullaraMustacheVersionAccessors;
        }

    }

    public static class ComGithubSpullaraMustacheVersionAccessors extends VersionFactory  {

        private final ComGithubSpullaraMustacheJavaVersionAccessors vaccForComGithubSpullaraMustacheJavaVersionAccessors = new ComGithubSpullaraMustacheJavaVersionAccessors(providers, config);
        public ComGithubSpullaraMustacheVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.com.github.spullara.mustache.java</b>
         */
        public ComGithubSpullaraMustacheJavaVersionAccessors getJava() {
            return vaccForComGithubSpullaraMustacheJavaVersionAccessors;
        }

    }

    public static class ComGithubSpullaraMustacheJavaVersionAccessors extends VersionFactory  {

        public ComGithubSpullaraMustacheJavaVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>com.github.spullara.mustache.java.compiler</b> with value <b>0.9.4</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getCompiler() { return getVersion("com.github.spullara.mustache.java.compiler"); }

    }

    public static class ComGoogleVersionAccessors extends VersionFactory  {

        private final ComGoogleCodeVersionAccessors vaccForComGoogleCodeVersionAccessors = new ComGoogleCodeVersionAccessors(providers, config);
        private final ComGoogleGuavaVersionAccessors vaccForComGoogleGuavaVersionAccessors = new ComGoogleGuavaVersionAccessors(providers, config);
        public ComGoogleVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.com.google.code</b>
         */
        public ComGoogleCodeVersionAccessors getCode() {
            return vaccForComGoogleCodeVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.com.google.guava</b>
         */
        public ComGoogleGuavaVersionAccessors getGuava() {
            return vaccForComGoogleGuavaVersionAccessors;
        }

    }

    public static class ComGoogleCodeVersionAccessors extends VersionFactory  {

        private final ComGoogleCodeFindbugsVersionAccessors vaccForComGoogleCodeFindbugsVersionAccessors = new ComGoogleCodeFindbugsVersionAccessors(providers, config);
        private final ComGoogleCodeGsonVersionAccessors vaccForComGoogleCodeGsonVersionAccessors = new ComGoogleCodeGsonVersionAccessors(providers, config);
        public ComGoogleCodeVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.com.google.code.findbugs</b>
         */
        public ComGoogleCodeFindbugsVersionAccessors getFindbugs() {
            return vaccForComGoogleCodeFindbugsVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.com.google.code.gson</b>
         */
        public ComGoogleCodeGsonVersionAccessors getGson() {
            return vaccForComGoogleCodeGsonVersionAccessors;
        }

    }

    public static class ComGoogleCodeFindbugsVersionAccessors extends VersionFactory  {

        public ComGoogleCodeFindbugsVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>com.google.code.findbugs.jsr305</b> with value <b>3.0.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getJsr305() { return getVersion("com.google.code.findbugs.jsr305"); }

    }

    public static class ComGoogleCodeGsonVersionAccessors extends VersionFactory  {

        public ComGoogleCodeGsonVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>com.google.code.gson.gson</b> with value <b>2.10.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getGson() { return getVersion("com.google.code.gson.gson"); }

    }

    public static class ComGoogleGuavaVersionAccessors extends VersionFactory  {

        public ComGoogleGuavaVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>com.google.guava.guava</b> with value <b>33.2.1-jre</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getGuava() { return getVersion("com.google.guava.guava"); }

    }

    public static class ComNimbusdsVersionAccessors extends VersionFactory  {

        private final ComNimbusdsOauth2VersionAccessors vaccForComNimbusdsOauth2VersionAccessors = new ComNimbusdsOauth2VersionAccessors(providers, config);
        public ComNimbusdsVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.com.nimbusds.oauth2</b>
         */
        public ComNimbusdsOauth2VersionAccessors getOauth2() {
            return vaccForComNimbusdsOauth2VersionAccessors;
        }

    }

    public static class ComNimbusdsOauth2VersionAccessors extends VersionFactory  {

        private final ComNimbusdsOauth2OidcVersionAccessors vaccForComNimbusdsOauth2OidcVersionAccessors = new ComNimbusdsOauth2OidcVersionAccessors(providers, config);
        public ComNimbusdsOauth2VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.com.nimbusds.oauth2.oidc</b>
         */
        public ComNimbusdsOauth2OidcVersionAccessors getOidc() {
            return vaccForComNimbusdsOauth2OidcVersionAccessors;
        }

    }

    public static class ComNimbusdsOauth2OidcVersionAccessors extends VersionFactory  {

        public ComNimbusdsOauth2OidcVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>com.nimbusds.oauth2.oidc.sdk</b> with value <b>11.12</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getSdk() { return getVersion("com.nimbusds.oauth2.oidc.sdk"); }

    }

    public static class CommonsVersionAccessors extends VersionFactory  {

        private final CommonsIoVersionAccessors vaccForCommonsIoVersionAccessors = new CommonsIoVersionAccessors(providers, config);
        public CommonsVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.commons.io</b>
         */
        public CommonsIoVersionAccessors getIo() {
            return vaccForCommonsIoVersionAccessors;
        }

    }

    public static class CommonsIoVersionAccessors extends VersionFactory  {

        private final CommonsIoCommonsVersionAccessors vaccForCommonsIoCommonsVersionAccessors = new CommonsIoCommonsVersionAccessors(providers, config);
        public CommonsIoVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.commons.io.commons</b>
         */
        public CommonsIoCommonsVersionAccessors getCommons() {
            return vaccForCommonsIoCommonsVersionAccessors;
        }

    }

    public static class CommonsIoCommonsVersionAccessors extends VersionFactory  {

        public CommonsIoCommonsVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>commons.io.commons.io</b> with value <b>2.13.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getIo() { return getVersion("commons.io.commons.io"); }

    }

    public static class IoVersionAccessors extends VersionFactory  {

        private final IoMoquetteVersionAccessors vaccForIoMoquetteVersionAccessors = new IoMoquetteVersionAccessors(providers, config);
        public IoVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.io.moquette</b>
         */
        public IoMoquetteVersionAccessors getMoquette() {
            return vaccForIoMoquetteVersionAccessors;
        }

    }

    public static class IoMoquetteVersionAccessors extends VersionFactory  {

        private final IoMoquetteMoquetteVersionAccessors vaccForIoMoquetteMoquetteVersionAccessors = new IoMoquetteMoquetteVersionAccessors(providers, config);
        public IoMoquetteVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.io.moquette.moquette</b>
         */
        public IoMoquetteMoquetteVersionAccessors getMoquette() {
            return vaccForIoMoquetteMoquetteVersionAccessors;
        }

    }

    public static class IoMoquetteMoquetteVersionAccessors extends VersionFactory  {

        public IoMoquetteMoquetteVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>io.moquette.moquette.broker</b> with value <b>0.16</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getBroker() { return getVersion("io.moquette.moquette.broker"); }

    }

    public static class JakartaVersionAccessors extends VersionFactory  {

        private final JakartaAnnotationVersionAccessors vaccForJakartaAnnotationVersionAccessors = new JakartaAnnotationVersionAccessors(providers, config);
        private final JakartaValidationVersionAccessors vaccForJakartaValidationVersionAccessors = new JakartaValidationVersionAccessors(providers, config);
        public JakartaVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.jakarta.annotation</b>
         */
        public JakartaAnnotationVersionAccessors getAnnotation() {
            return vaccForJakartaAnnotationVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.jakarta.validation</b>
         */
        public JakartaValidationVersionAccessors getValidation() {
            return vaccForJakartaValidationVersionAccessors;
        }

    }

    public static class JakartaAnnotationVersionAccessors extends VersionFactory  {

        private final JakartaAnnotationJakartaVersionAccessors vaccForJakartaAnnotationJakartaVersionAccessors = new JakartaAnnotationJakartaVersionAccessors(providers, config);
        public JakartaAnnotationVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.jakarta.annotation.jakarta</b>
         */
        public JakartaAnnotationJakartaVersionAccessors getJakarta() {
            return vaccForJakartaAnnotationJakartaVersionAccessors;
        }

    }

    public static class JakartaAnnotationJakartaVersionAccessors extends VersionFactory  {

        private final JakartaAnnotationJakartaAnnotationVersionAccessors vaccForJakartaAnnotationJakartaAnnotationVersionAccessors = new JakartaAnnotationJakartaAnnotationVersionAccessors(providers, config);
        public JakartaAnnotationJakartaVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.jakarta.annotation.jakarta.annotation</b>
         */
        public JakartaAnnotationJakartaAnnotationVersionAccessors getAnnotation() {
            return vaccForJakartaAnnotationJakartaAnnotationVersionAccessors;
        }

    }

    public static class JakartaAnnotationJakartaAnnotationVersionAccessors extends VersionFactory  {

        public JakartaAnnotationJakartaAnnotationVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>jakarta.annotation.jakarta.annotation.api</b> with value <b>2.1.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getApi() { return getVersion("jakarta.annotation.jakarta.annotation.api"); }

    }

    public static class JakartaValidationVersionAccessors extends VersionFactory  {

        private final JakartaValidationJakartaVersionAccessors vaccForJakartaValidationJakartaVersionAccessors = new JakartaValidationJakartaVersionAccessors(providers, config);
        public JakartaValidationVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.jakarta.validation.jakarta</b>
         */
        public JakartaValidationJakartaVersionAccessors getJakarta() {
            return vaccForJakartaValidationJakartaVersionAccessors;
        }

    }

    public static class JakartaValidationJakartaVersionAccessors extends VersionFactory  {

        private final JakartaValidationJakartaValidationVersionAccessors vaccForJakartaValidationJakartaValidationVersionAccessors = new JakartaValidationJakartaValidationVersionAccessors(providers, config);
        public JakartaValidationJakartaVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.jakarta.validation.jakarta.validation</b>
         */
        public JakartaValidationJakartaValidationVersionAccessors getValidation() {
            return vaccForJakartaValidationJakartaValidationVersionAccessors;
        }

    }

    public static class JakartaValidationJakartaValidationVersionAccessors extends VersionFactory  {

        public JakartaValidationJakartaValidationVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>jakarta.validation.jakarta.validation.api</b> with value <b>3.0.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getApi() { return getVersion("jakarta.validation.jakarta.validation.api"); }

    }

    public static class OrgVersionAccessors extends VersionFactory  {

        private final OrgApacheVersionAccessors vaccForOrgApacheVersionAccessors = new OrgApacheVersionAccessors(providers, config);
        private final OrgEclipseVersionAccessors vaccForOrgEclipseVersionAccessors = new OrgEclipseVersionAccessors(providers, config);
        private final OrgHibernateVersionAccessors vaccForOrgHibernateVersionAccessors = new OrgHibernateVersionAccessors(providers, config);
        private final OrgJsonVersionAccessors vaccForOrgJsonVersionAccessors = new OrgJsonVersionAccessors(providers, config);
        private final OrgJunitVersionAccessors vaccForOrgJunitVersionAccessors = new OrgJunitVersionAccessors(providers, config);
        private final OrgMockVersionAccessors vaccForOrgMockVersionAccessors = new OrgMockVersionAccessors(providers, config);
        private final OrgMockitoVersionAccessors vaccForOrgMockitoVersionAccessors = new OrgMockitoVersionAccessors(providers, config);
        private final OrgOpenapitoolsVersionAccessors vaccForOrgOpenapitoolsVersionAccessors = new OrgOpenapitoolsVersionAccessors(providers, config);
        private final OrgProjectlombokVersionAccessors vaccForOrgProjectlombokVersionAccessors = new OrgProjectlombokVersionAccessors(providers, config);
        private final OrgReflectionsVersionAccessors vaccForOrgReflectionsVersionAccessors = new OrgReflectionsVersionAccessors(providers, config);
        private final OrgSlf4jVersionAccessors vaccForOrgSlf4jVersionAccessors = new OrgSlf4jVersionAccessors(providers, config);
        private final OrgSpringdocVersionAccessors vaccForOrgSpringdocVersionAccessors = new OrgSpringdocVersionAccessors(providers, config);
        private final OrgSpringframeworkVersionAccessors vaccForOrgSpringframeworkVersionAccessors = new OrgSpringframeworkVersionAccessors(providers, config);
        private final OrgXmlunitVersionAccessors vaccForOrgXmlunitVersionAccessors = new OrgXmlunitVersionAccessors(providers, config);
        private final OrgYamlVersionAccessors vaccForOrgYamlVersionAccessors = new OrgYamlVersionAccessors(providers, config);
        public OrgVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.apache</b>
         */
        public OrgApacheVersionAccessors getApache() {
            return vaccForOrgApacheVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.org.eclipse</b>
         */
        public OrgEclipseVersionAccessors getEclipse() {
            return vaccForOrgEclipseVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.org.hibernate</b>
         */
        public OrgHibernateVersionAccessors getHibernate() {
            return vaccForOrgHibernateVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.org.json</b>
         */
        public OrgJsonVersionAccessors getJson() {
            return vaccForOrgJsonVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.org.junit</b>
         */
        public OrgJunitVersionAccessors getJunit() {
            return vaccForOrgJunitVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.org.mock</b>
         */
        public OrgMockVersionAccessors getMock() {
            return vaccForOrgMockVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.org.mockito</b>
         */
        public OrgMockitoVersionAccessors getMockito() {
            return vaccForOrgMockitoVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.org.openapitools</b>
         */
        public OrgOpenapitoolsVersionAccessors getOpenapitools() {
            return vaccForOrgOpenapitoolsVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.org.projectlombok</b>
         */
        public OrgProjectlombokVersionAccessors getProjectlombok() {
            return vaccForOrgProjectlombokVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.org.reflections</b>
         */
        public OrgReflectionsVersionAccessors getReflections() {
            return vaccForOrgReflectionsVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.org.slf4j</b>
         */
        public OrgSlf4jVersionAccessors getSlf4j() {
            return vaccForOrgSlf4jVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.org.springdoc</b>
         */
        public OrgSpringdocVersionAccessors getSpringdoc() {
            return vaccForOrgSpringdocVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.org.springframework</b>
         */
        public OrgSpringframeworkVersionAccessors getSpringframework() {
            return vaccForOrgSpringframeworkVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.org.xmlunit</b>
         */
        public OrgXmlunitVersionAccessors getXmlunit() {
            return vaccForOrgXmlunitVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.org.yaml</b>
         */
        public OrgYamlVersionAccessors getYaml() {
            return vaccForOrgYamlVersionAccessors;
        }

    }

    public static class OrgApacheVersionAccessors extends VersionFactory  {

        private final OrgApacheCommonsVersionAccessors vaccForOrgApacheCommonsVersionAccessors = new OrgApacheCommonsVersionAccessors(providers, config);
        private final OrgApacheHttpcomponentsVersionAccessors vaccForOrgApacheHttpcomponentsVersionAccessors = new OrgApacheHttpcomponentsVersionAccessors(providers, config);
        private final OrgApacheMavenVersionAccessors vaccForOrgApacheMavenVersionAccessors = new OrgApacheMavenVersionAccessors(providers, config);
        private final OrgApachePoiVersionAccessors vaccForOrgApachePoiVersionAccessors = new OrgApachePoiVersionAccessors(providers, config);
        private final OrgApacheTikaVersionAccessors vaccForOrgApacheTikaVersionAccessors = new OrgApacheTikaVersionAccessors(providers, config);
        public OrgApacheVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.apache.commons</b>
         */
        public OrgApacheCommonsVersionAccessors getCommons() {
            return vaccForOrgApacheCommonsVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.org.apache.httpcomponents</b>
         */
        public OrgApacheHttpcomponentsVersionAccessors getHttpcomponents() {
            return vaccForOrgApacheHttpcomponentsVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.org.apache.maven</b>
         */
        public OrgApacheMavenVersionAccessors getMaven() {
            return vaccForOrgApacheMavenVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.org.apache.poi</b>
         */
        public OrgApachePoiVersionAccessors getPoi() {
            return vaccForOrgApachePoiVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.org.apache.tika</b>
         */
        public OrgApacheTikaVersionAccessors getTika() {
            return vaccForOrgApacheTikaVersionAccessors;
        }

    }

    public static class OrgApacheCommonsVersionAccessors extends VersionFactory  {

        private final OrgApacheCommonsCommonsVersionAccessors vaccForOrgApacheCommonsCommonsVersionAccessors = new OrgApacheCommonsCommonsVersionAccessors(providers, config);
        public OrgApacheCommonsVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.apache.commons.commons</b>
         */
        public OrgApacheCommonsCommonsVersionAccessors getCommons() {
            return vaccForOrgApacheCommonsCommonsVersionAccessors;
        }

    }

    public static class OrgApacheCommonsCommonsVersionAccessors extends VersionFactory  {

        public OrgApacheCommonsCommonsVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.apache.commons.commons.lang3</b> with value <b>3.12.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getLang3() { return getVersion("org.apache.commons.commons.lang3"); }

    }

    public static class OrgApacheHttpcomponentsVersionAccessors extends VersionFactory  {

        private final OrgApacheHttpcomponentsClient5VersionAccessors vaccForOrgApacheHttpcomponentsClient5VersionAccessors = new OrgApacheHttpcomponentsClient5VersionAccessors(providers, config);
        public OrgApacheHttpcomponentsVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.apache.httpcomponents.httpmime</b> with value <b>4.5.14</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getHttpmime() { return getVersion("org.apache.httpcomponents.httpmime"); }

        /**
         * Group of versions at <b>versions.org.apache.httpcomponents.client5</b>
         */
        public OrgApacheHttpcomponentsClient5VersionAccessors getClient5() {
            return vaccForOrgApacheHttpcomponentsClient5VersionAccessors;
        }

    }

    public static class OrgApacheHttpcomponentsClient5VersionAccessors extends VersionFactory  {

        public OrgApacheHttpcomponentsClient5VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.apache.httpcomponents.client5.httpclient5</b> with value <b>5.2.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getHttpclient5() { return getVersion("org.apache.httpcomponents.client5.httpclient5"); }

    }

    public static class OrgApacheMavenVersionAccessors extends VersionFactory  {

        private final OrgApacheMavenMavenVersionAccessors vaccForOrgApacheMavenMavenVersionAccessors = new OrgApacheMavenMavenVersionAccessors(providers, config);
        private final OrgApacheMavenPluginVersionAccessors vaccForOrgApacheMavenPluginVersionAccessors = new OrgApacheMavenPluginVersionAccessors(providers, config);
        public OrgApacheMavenVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.apache.maven.maven</b>
         */
        public OrgApacheMavenMavenVersionAccessors getMaven() {
            return vaccForOrgApacheMavenMavenVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.org.apache.maven.plugin</b>
         */
        public OrgApacheMavenPluginVersionAccessors getPlugin() {
            return vaccForOrgApacheMavenPluginVersionAccessors;
        }

    }

    public static class OrgApacheMavenMavenVersionAccessors extends VersionFactory  {

        private final OrgApacheMavenMavenPluginVersionAccessors vaccForOrgApacheMavenMavenPluginVersionAccessors = new OrgApacheMavenMavenPluginVersionAccessors(providers, config);
        public OrgApacheMavenMavenVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.apache.maven.maven.project</b> with value <b>3.0-alpha-2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getProject() { return getVersion("org.apache.maven.maven.project"); }

        /**
         * Group of versions at <b>versions.org.apache.maven.maven.plugin</b>
         */
        public OrgApacheMavenMavenPluginVersionAccessors getPlugin() {
            return vaccForOrgApacheMavenMavenPluginVersionAccessors;
        }

    }

    public static class OrgApacheMavenMavenPluginVersionAccessors extends VersionFactory  {

        public OrgApacheMavenMavenPluginVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.apache.maven.maven.plugin.api</b> with value <b>3.9.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getApi() { return getVersion("org.apache.maven.maven.plugin.api"); }

    }

    public static class OrgApacheMavenPluginVersionAccessors extends VersionFactory  {

        private final OrgApacheMavenPluginToolsVersionAccessors vaccForOrgApacheMavenPluginToolsVersionAccessors = new OrgApacheMavenPluginToolsVersionAccessors(providers, config);
        public OrgApacheMavenPluginVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.apache.maven.plugin.tools</b>
         */
        public OrgApacheMavenPluginToolsVersionAccessors getTools() {
            return vaccForOrgApacheMavenPluginToolsVersionAccessors;
        }

    }

    public static class OrgApacheMavenPluginToolsVersionAccessors extends VersionFactory  {

        private final OrgApacheMavenPluginToolsMavenVersionAccessors vaccForOrgApacheMavenPluginToolsMavenVersionAccessors = new OrgApacheMavenPluginToolsMavenVersionAccessors(providers, config);
        public OrgApacheMavenPluginToolsVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.apache.maven.plugin.tools.maven</b>
         */
        public OrgApacheMavenPluginToolsMavenVersionAccessors getMaven() {
            return vaccForOrgApacheMavenPluginToolsMavenVersionAccessors;
        }

    }

    public static class OrgApacheMavenPluginToolsMavenVersionAccessors extends VersionFactory  {

        private final OrgApacheMavenPluginToolsMavenPluginVersionAccessors vaccForOrgApacheMavenPluginToolsMavenPluginVersionAccessors = new OrgApacheMavenPluginToolsMavenPluginVersionAccessors(providers, config);
        public OrgApacheMavenPluginToolsMavenVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.apache.maven.plugin.tools.maven.plugin</b>
         */
        public OrgApacheMavenPluginToolsMavenPluginVersionAccessors getPlugin() {
            return vaccForOrgApacheMavenPluginToolsMavenPluginVersionAccessors;
        }

    }

    public static class OrgApacheMavenPluginToolsMavenPluginVersionAccessors extends VersionFactory  {

        public OrgApacheMavenPluginToolsMavenPluginVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.apache.maven.plugin.tools.maven.plugin.annotations</b> with value <b>3.9.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getAnnotations() { return getVersion("org.apache.maven.plugin.tools.maven.plugin.annotations"); }

    }

    public static class OrgApachePoiVersionAccessors extends VersionFactory  {

        private final OrgApachePoiPoiVersionAccessors vaccForOrgApachePoiPoiVersionAccessors = new OrgApachePoiPoiVersionAccessors(providers, config);
        public OrgApachePoiVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.apache.poi.poi</b>
         */
        public OrgApachePoiPoiVersionAccessors getPoi() {
            return vaccForOrgApachePoiPoiVersionAccessors;
        }

    }

    public static class OrgApachePoiPoiVersionAccessors extends VersionFactory  {

        public OrgApachePoiPoiVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.apache.poi.poi.ooxml</b> with value <b>4.1.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getOoxml() { return getVersion("org.apache.poi.poi.ooxml"); }

    }

    public static class OrgApacheTikaVersionAccessors extends VersionFactory  {

        private final OrgApacheTikaTikaVersionAccessors vaccForOrgApacheTikaTikaVersionAccessors = new OrgApacheTikaTikaVersionAccessors(providers, config);
        public OrgApacheTikaVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.apache.tika.tika</b>
         */
        public OrgApacheTikaTikaVersionAccessors getTika() {
            return vaccForOrgApacheTikaTikaVersionAccessors;
        }

    }

    public static class OrgApacheTikaTikaVersionAccessors extends VersionFactory  {

        public OrgApacheTikaTikaVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.apache.tika.tika.core</b> with value <b>2.8.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getCore() { return getVersion("org.apache.tika.tika.core"); }

    }

    public static class OrgEclipseVersionAccessors extends VersionFactory  {

        private final OrgEclipseDigitaltwinVersionAccessors vaccForOrgEclipseDigitaltwinVersionAccessors = new OrgEclipseDigitaltwinVersionAccessors(providers, config);
        private final OrgEclipsePahoVersionAccessors vaccForOrgEclipsePahoVersionAccessors = new OrgEclipsePahoVersionAccessors(providers, config);
        public OrgEclipseVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.eclipse.digitaltwin</b>
         */
        public OrgEclipseDigitaltwinVersionAccessors getDigitaltwin() {
            return vaccForOrgEclipseDigitaltwinVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.org.eclipse.paho</b>
         */
        public OrgEclipsePahoVersionAccessors getPaho() {
            return vaccForOrgEclipsePahoVersionAccessors;
        }

    }

    public static class OrgEclipseDigitaltwinVersionAccessors extends VersionFactory  {

        private final OrgEclipseDigitaltwinAas4jVersionAccessors vaccForOrgEclipseDigitaltwinAas4jVersionAccessors = new OrgEclipseDigitaltwinAas4jVersionAccessors(providers, config);
        public OrgEclipseDigitaltwinVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.eclipse.digitaltwin.aas4j</b>
         */
        public OrgEclipseDigitaltwinAas4jVersionAccessors getAas4j() {
            return vaccForOrgEclipseDigitaltwinAas4jVersionAccessors;
        }

    }

    public static class OrgEclipseDigitaltwinAas4jVersionAccessors extends VersionFactory  {

        private final OrgEclipseDigitaltwinAas4jAas4jVersionAccessors vaccForOrgEclipseDigitaltwinAas4jAas4jVersionAccessors = new OrgEclipseDigitaltwinAas4jAas4jVersionAccessors(providers, config);
        public OrgEclipseDigitaltwinAas4jVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.eclipse.digitaltwin.aas4j.aas4j</b>
         */
        public OrgEclipseDigitaltwinAas4jAas4jVersionAccessors getAas4j() {
            return vaccForOrgEclipseDigitaltwinAas4jAas4jVersionAccessors;
        }

    }

    public static class OrgEclipseDigitaltwinAas4jAas4jVersionAccessors extends VersionFactory  {

        private final OrgEclipseDigitaltwinAas4jAas4jDataformatVersionAccessors vaccForOrgEclipseDigitaltwinAas4jAas4jDataformatVersionAccessors = new OrgEclipseDigitaltwinAas4jAas4jDataformatVersionAccessors(providers, config);
        public OrgEclipseDigitaltwinAas4jAas4jVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.eclipse.digitaltwin.aas4j.aas4j.model</b> with value <b>1.0.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getModel() { return getVersion("org.eclipse.digitaltwin.aas4j.aas4j.model"); }

        /**
         * Group of versions at <b>versions.org.eclipse.digitaltwin.aas4j.aas4j.dataformat</b>
         */
        public OrgEclipseDigitaltwinAas4jAas4jDataformatVersionAccessors getDataformat() {
            return vaccForOrgEclipseDigitaltwinAas4jAas4jDataformatVersionAccessors;
        }

    }

    public static class OrgEclipseDigitaltwinAas4jAas4jDataformatVersionAccessors extends VersionFactory  {

        public OrgEclipseDigitaltwinAas4jAas4jDataformatVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.eclipse.digitaltwin.aas4j.aas4j.dataformat.aasx</b> with value <b>1.0.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getAasx() { return getVersion("org.eclipse.digitaltwin.aas4j.aas4j.dataformat.aasx"); }

        /**
         * Version alias <b>org.eclipse.digitaltwin.aas4j.aas4j.dataformat.core</b> with value <b>1.0.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getCore() { return getVersion("org.eclipse.digitaltwin.aas4j.aas4j.dataformat.core"); }

        /**
         * Version alias <b>org.eclipse.digitaltwin.aas4j.aas4j.dataformat.json</b> with value <b>1.0.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getJson() { return getVersion("org.eclipse.digitaltwin.aas4j.aas4j.dataformat.json"); }

        /**
         * Version alias <b>org.eclipse.digitaltwin.aas4j.aas4j.dataformat.xml</b> with value <b>1.0.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getXml() { return getVersion("org.eclipse.digitaltwin.aas4j.aas4j.dataformat.xml"); }

    }

    public static class OrgEclipsePahoVersionAccessors extends VersionFactory  {

        private final OrgEclipsePahoOrgVersionAccessors vaccForOrgEclipsePahoOrgVersionAccessors = new OrgEclipsePahoOrgVersionAccessors(providers, config);
        public OrgEclipsePahoVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.eclipse.paho.org</b>
         */
        public OrgEclipsePahoOrgVersionAccessors getOrg() {
            return vaccForOrgEclipsePahoOrgVersionAccessors;
        }

    }

    public static class OrgEclipsePahoOrgVersionAccessors extends VersionFactory  {

        private final OrgEclipsePahoOrgEclipseVersionAccessors vaccForOrgEclipsePahoOrgEclipseVersionAccessors = new OrgEclipsePahoOrgEclipseVersionAccessors(providers, config);
        public OrgEclipsePahoOrgVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.eclipse.paho.org.eclipse</b>
         */
        public OrgEclipsePahoOrgEclipseVersionAccessors getEclipse() {
            return vaccForOrgEclipsePahoOrgEclipseVersionAccessors;
        }

    }

    public static class OrgEclipsePahoOrgEclipseVersionAccessors extends VersionFactory  {

        private final OrgEclipsePahoOrgEclipsePahoVersionAccessors vaccForOrgEclipsePahoOrgEclipsePahoVersionAccessors = new OrgEclipsePahoOrgEclipsePahoVersionAccessors(providers, config);
        public OrgEclipsePahoOrgEclipseVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.eclipse.paho.org.eclipse.paho</b>
         */
        public OrgEclipsePahoOrgEclipsePahoVersionAccessors getPaho() {
            return vaccForOrgEclipsePahoOrgEclipsePahoVersionAccessors;
        }

    }

    public static class OrgEclipsePahoOrgEclipsePahoVersionAccessors extends VersionFactory  {

        private final OrgEclipsePahoOrgEclipsePahoClientVersionAccessors vaccForOrgEclipsePahoOrgEclipsePahoClientVersionAccessors = new OrgEclipsePahoOrgEclipsePahoClientVersionAccessors(providers, config);
        public OrgEclipsePahoOrgEclipsePahoVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.eclipse.paho.org.eclipse.paho.client</b>
         */
        public OrgEclipsePahoOrgEclipsePahoClientVersionAccessors getClient() {
            return vaccForOrgEclipsePahoOrgEclipsePahoClientVersionAccessors;
        }

    }

    public static class OrgEclipsePahoOrgEclipsePahoClientVersionAccessors extends VersionFactory  {

        public OrgEclipsePahoOrgEclipsePahoClientVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.eclipse.paho.org.eclipse.paho.client.mqttv3</b> with value <b>1.2.5</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getMqttv3() { return getVersion("org.eclipse.paho.org.eclipse.paho.client.mqttv3"); }

    }

    public static class OrgHibernateVersionAccessors extends VersionFactory  {

        private final OrgHibernateValidatorVersionAccessors vaccForOrgHibernateValidatorVersionAccessors = new OrgHibernateValidatorVersionAccessors(providers, config);
        public OrgHibernateVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.hibernate.validator</b>
         */
        public OrgHibernateValidatorVersionAccessors getValidator() {
            return vaccForOrgHibernateValidatorVersionAccessors;
        }

    }

    public static class OrgHibernateValidatorVersionAccessors extends VersionFactory  {

        private final OrgHibernateValidatorHibernateVersionAccessors vaccForOrgHibernateValidatorHibernateVersionAccessors = new OrgHibernateValidatorHibernateVersionAccessors(providers, config);
        public OrgHibernateValidatorVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.hibernate.validator.hibernate</b>
         */
        public OrgHibernateValidatorHibernateVersionAccessors getHibernate() {
            return vaccForOrgHibernateValidatorHibernateVersionAccessors;
        }

    }

    public static class OrgHibernateValidatorHibernateVersionAccessors extends VersionFactory  {

        public OrgHibernateValidatorHibernateVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.hibernate.validator.hibernate.validator</b> with value <b>8.0.1.Final</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getValidator() { return getVersion("org.hibernate.validator.hibernate.validator"); }

    }

    public static class OrgJsonVersionAccessors extends VersionFactory  {

        public OrgJsonVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.json.json</b> with value <b>20240303</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getJson() { return getVersion("org.json.json"); }

    }

    public static class OrgJunitVersionAccessors extends VersionFactory  {

        private final OrgJunitVintageVersionAccessors vaccForOrgJunitVintageVersionAccessors = new OrgJunitVintageVersionAccessors(providers, config);
        public OrgJunitVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.junit.vintage</b>
         */
        public OrgJunitVintageVersionAccessors getVintage() {
            return vaccForOrgJunitVintageVersionAccessors;
        }

    }

    public static class OrgJunitVintageVersionAccessors extends VersionFactory  {

        private final OrgJunitVintageJunitVersionAccessors vaccForOrgJunitVintageJunitVersionAccessors = new OrgJunitVintageJunitVersionAccessors(providers, config);
        public OrgJunitVintageVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.junit.vintage.junit</b>
         */
        public OrgJunitVintageJunitVersionAccessors getJunit() {
            return vaccForOrgJunitVintageJunitVersionAccessors;
        }

    }

    public static class OrgJunitVintageJunitVersionAccessors extends VersionFactory  {

        private final OrgJunitVintageJunitVintageVersionAccessors vaccForOrgJunitVintageJunitVintageVersionAccessors = new OrgJunitVintageJunitVintageVersionAccessors(providers, config);
        public OrgJunitVintageJunitVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.junit.vintage.junit.vintage</b>
         */
        public OrgJunitVintageJunitVintageVersionAccessors getVintage() {
            return vaccForOrgJunitVintageJunitVintageVersionAccessors;
        }

    }

    public static class OrgJunitVintageJunitVintageVersionAccessors extends VersionFactory  {

        public OrgJunitVintageJunitVintageVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.junit.vintage.junit.vintage.engine</b> with value <b>5.9.3</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getEngine() { return getVersion("org.junit.vintage.junit.vintage.engine"); }

    }

    public static class OrgMockVersionAccessors extends VersionFactory  {

        private final OrgMockServerVersionAccessors vaccForOrgMockServerVersionAccessors = new OrgMockServerVersionAccessors(providers, config);
        public OrgMockVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.mock.server</b>
         */
        public OrgMockServerVersionAccessors getServer() {
            return vaccForOrgMockServerVersionAccessors;
        }

    }

    public static class OrgMockServerVersionAccessors extends VersionFactory  {

        private final OrgMockServerMockserverVersionAccessors vaccForOrgMockServerMockserverVersionAccessors = new OrgMockServerMockserverVersionAccessors(providers, config);
        public OrgMockServerVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.mock.server.mockserver</b>
         */
        public OrgMockServerMockserverVersionAccessors getMockserver() {
            return vaccForOrgMockServerMockserverVersionAccessors;
        }

    }

    public static class OrgMockServerMockserverVersionAccessors extends VersionFactory  {

        public OrgMockServerMockserverVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.mock.server.mockserver.netty</b> with value <b>5.15.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getNetty() { return getVersion("org.mock.server.mockserver.netty"); }

    }

    public static class OrgMockitoVersionAccessors extends VersionFactory  {

        private final OrgMockitoMockitoVersionAccessors vaccForOrgMockitoMockitoVersionAccessors = new OrgMockitoMockitoVersionAccessors(providers, config);
        public OrgMockitoVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.mockito.mockito</b>
         */
        public OrgMockitoMockitoVersionAccessors getMockito() {
            return vaccForOrgMockitoMockitoVersionAccessors;
        }

    }

    public static class OrgMockitoMockitoVersionAccessors extends VersionFactory  {

        public OrgMockitoMockitoVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.mockito.mockito.core</b> with value <b>5.3.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getCore() { return getVersion("org.mockito.mockito.core"); }

    }

    public static class OrgOpenapitoolsVersionAccessors extends VersionFactory  {

        private final OrgOpenapitoolsJacksonVersionAccessors vaccForOrgOpenapitoolsJacksonVersionAccessors = new OrgOpenapitoolsJacksonVersionAccessors(providers, config);
        public OrgOpenapitoolsVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.openapitools.jackson</b>
         */
        public OrgOpenapitoolsJacksonVersionAccessors getJackson() {
            return vaccForOrgOpenapitoolsJacksonVersionAccessors;
        }

    }

    public static class OrgOpenapitoolsJacksonVersionAccessors extends VersionFactory  {

        private final OrgOpenapitoolsJacksonDatabindVersionAccessors vaccForOrgOpenapitoolsJacksonDatabindVersionAccessors = new OrgOpenapitoolsJacksonDatabindVersionAccessors(providers, config);
        public OrgOpenapitoolsJacksonVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.openapitools.jackson.databind</b>
         */
        public OrgOpenapitoolsJacksonDatabindVersionAccessors getDatabind() {
            return vaccForOrgOpenapitoolsJacksonDatabindVersionAccessors;
        }

    }

    public static class OrgOpenapitoolsJacksonDatabindVersionAccessors extends VersionFactory  {

        public OrgOpenapitoolsJacksonDatabindVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.openapitools.jackson.databind.nullable</b> with value <b>0.2.6</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getNullable() { return getVersion("org.openapitools.jackson.databind.nullable"); }

    }

    public static class OrgProjectlombokVersionAccessors extends VersionFactory  {

        public OrgProjectlombokVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.projectlombok.lombok</b> with value <b>1.18.30</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getLombok() { return getVersion("org.projectlombok.lombok"); }

    }

    public static class OrgReflectionsVersionAccessors extends VersionFactory  {

        public OrgReflectionsVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.reflections.reflections</b> with value <b>0.10.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getReflections() { return getVersion("org.reflections.reflections"); }

    }

    public static class OrgSlf4jVersionAccessors extends VersionFactory  {

        private final OrgSlf4jSlf4jVersionAccessors vaccForOrgSlf4jSlf4jVersionAccessors = new OrgSlf4jSlf4jVersionAccessors(providers, config);
        public OrgSlf4jVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.slf4j.slf4j</b>
         */
        public OrgSlf4jSlf4jVersionAccessors getSlf4j() {
            return vaccForOrgSlf4jSlf4jVersionAccessors;
        }

    }

    public static class OrgSlf4jSlf4jVersionAccessors extends VersionFactory  {

        public OrgSlf4jSlf4jVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.slf4j.slf4j.api</b> with value <b>2.0.9</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getApi() { return getVersion("org.slf4j.slf4j.api"); }

        /**
         * Version alias <b>org.slf4j.slf4j.simple</b> with value <b>2.0.9</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getSimple() { return getVersion("org.slf4j.slf4j.simple"); }

    }

    public static class OrgSpringdocVersionAccessors extends VersionFactory  {

        private final OrgSpringdocSpringdocVersionAccessors vaccForOrgSpringdocSpringdocVersionAccessors = new OrgSpringdocSpringdocVersionAccessors(providers, config);
        public OrgSpringdocVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.springdoc.springdoc</b>
         */
        public OrgSpringdocSpringdocVersionAccessors getSpringdoc() {
            return vaccForOrgSpringdocSpringdocVersionAccessors;
        }

    }

    public static class OrgSpringdocSpringdocVersionAccessors extends VersionFactory  {

        private final OrgSpringdocSpringdocOpenapiVersionAccessors vaccForOrgSpringdocSpringdocOpenapiVersionAccessors = new OrgSpringdocSpringdocOpenapiVersionAccessors(providers, config);
        public OrgSpringdocSpringdocVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.springdoc.springdoc.openapi</b>
         */
        public OrgSpringdocSpringdocOpenapiVersionAccessors getOpenapi() {
            return vaccForOrgSpringdocSpringdocOpenapiVersionAccessors;
        }

    }

    public static class OrgSpringdocSpringdocOpenapiVersionAccessors extends VersionFactory  {

        private final OrgSpringdocSpringdocOpenapiStarterVersionAccessors vaccForOrgSpringdocSpringdocOpenapiStarterVersionAccessors = new OrgSpringdocSpringdocOpenapiStarterVersionAccessors(providers, config);
        public OrgSpringdocSpringdocOpenapiVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.springdoc.springdoc.openapi.starter</b>
         */
        public OrgSpringdocSpringdocOpenapiStarterVersionAccessors getStarter() {
            return vaccForOrgSpringdocSpringdocOpenapiStarterVersionAccessors;
        }

    }

    public static class OrgSpringdocSpringdocOpenapiStarterVersionAccessors extends VersionFactory  {

        private final OrgSpringdocSpringdocOpenapiStarterWebmvcVersionAccessors vaccForOrgSpringdocSpringdocOpenapiStarterWebmvcVersionAccessors = new OrgSpringdocSpringdocOpenapiStarterWebmvcVersionAccessors(providers, config);
        public OrgSpringdocSpringdocOpenapiStarterVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.springdoc.springdoc.openapi.starter.webmvc</b>
         */
        public OrgSpringdocSpringdocOpenapiStarterWebmvcVersionAccessors getWebmvc() {
            return vaccForOrgSpringdocSpringdocOpenapiStarterWebmvcVersionAccessors;
        }

    }

    public static class OrgSpringdocSpringdocOpenapiStarterWebmvcVersionAccessors extends VersionFactory  {

        public OrgSpringdocSpringdocOpenapiStarterWebmvcVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.springdoc.springdoc.openapi.starter.webmvc.ui</b> with value <b>2.2.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getUi() { return getVersion("org.springdoc.springdoc.openapi.starter.webmvc.ui"); }

    }

    public static class OrgSpringframeworkVersionAccessors extends VersionFactory  {

        private final OrgSpringframeworkBootVersionAccessors vaccForOrgSpringframeworkBootVersionAccessors = new OrgSpringframeworkBootVersionAccessors(providers, config);
        private final OrgSpringframeworkCloudVersionAccessors vaccForOrgSpringframeworkCloudVersionAccessors = new OrgSpringframeworkCloudVersionAccessors(providers, config);
        private final OrgSpringframeworkDataVersionAccessors vaccForOrgSpringframeworkDataVersionAccessors = new OrgSpringframeworkDataVersionAccessors(providers, config);
        private final OrgSpringframeworkIntegrationVersionAccessors vaccForOrgSpringframeworkIntegrationVersionAccessors = new OrgSpringframeworkIntegrationVersionAccessors(providers, config);
        private final OrgSpringframeworkKafkaVersionAccessors vaccForOrgSpringframeworkKafkaVersionAccessors = new OrgSpringframeworkKafkaVersionAccessors(providers, config);
        private final OrgSpringframeworkSpringVersionAccessors vaccForOrgSpringframeworkSpringVersionAccessors = new OrgSpringframeworkSpringVersionAccessors(providers, config);
        public OrgSpringframeworkVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.springframework.boot</b>
         */
        public OrgSpringframeworkBootVersionAccessors getBoot() {
            return vaccForOrgSpringframeworkBootVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.org.springframework.cloud</b>
         */
        public OrgSpringframeworkCloudVersionAccessors getCloud() {
            return vaccForOrgSpringframeworkCloudVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.org.springframework.data</b>
         */
        public OrgSpringframeworkDataVersionAccessors getData() {
            return vaccForOrgSpringframeworkDataVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.org.springframework.integration</b>
         */
        public OrgSpringframeworkIntegrationVersionAccessors getIntegration() {
            return vaccForOrgSpringframeworkIntegrationVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.org.springframework.kafka</b>
         */
        public OrgSpringframeworkKafkaVersionAccessors getKafka() {
            return vaccForOrgSpringframeworkKafkaVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.org.springframework.spring</b>
         */
        public OrgSpringframeworkSpringVersionAccessors getSpring() {
            return vaccForOrgSpringframeworkSpringVersionAccessors;
        }

    }

    public static class OrgSpringframeworkBootVersionAccessors extends VersionFactory  {

        private final OrgSpringframeworkBootSpringVersionAccessors vaccForOrgSpringframeworkBootSpringVersionAccessors = new OrgSpringframeworkBootSpringVersionAccessors(providers, config);
        public OrgSpringframeworkBootVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.springframework.boot.spring</b>
         */
        public OrgSpringframeworkBootSpringVersionAccessors getSpring() {
            return vaccForOrgSpringframeworkBootSpringVersionAccessors;
        }

    }

    public static class OrgSpringframeworkBootSpringVersionAccessors extends VersionFactory  {

        private final OrgSpringframeworkBootSpringBootVersionAccessors vaccForOrgSpringframeworkBootSpringBootVersionAccessors = new OrgSpringframeworkBootSpringBootVersionAccessors(providers, config);
        public OrgSpringframeworkBootSpringVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.springframework.boot.spring.boot</b>
         */
        public OrgSpringframeworkBootSpringBootVersionAccessors getBoot() {
            return vaccForOrgSpringframeworkBootSpringBootVersionAccessors;
        }

    }

    public static class OrgSpringframeworkBootSpringBootVersionAccessors extends VersionFactory  {

        private final OrgSpringframeworkBootSpringBootActuatorVersionAccessors vaccForOrgSpringframeworkBootSpringBootActuatorVersionAccessors = new OrgSpringframeworkBootSpringBootActuatorVersionAccessors(providers, config);
        private final OrgSpringframeworkBootSpringBootConfigurationVersionAccessors vaccForOrgSpringframeworkBootSpringBootConfigurationVersionAccessors = new OrgSpringframeworkBootSpringBootConfigurationVersionAccessors(providers, config);
        private final OrgSpringframeworkBootSpringBootStarterVersionAccessors vaccForOrgSpringframeworkBootSpringBootStarterVersionAccessors = new OrgSpringframeworkBootSpringBootStarterVersionAccessors(providers, config);
        public OrgSpringframeworkBootSpringBootVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.springframework.boot.spring.boot.actuator</b>
         */
        public OrgSpringframeworkBootSpringBootActuatorVersionAccessors getActuator() {
            return vaccForOrgSpringframeworkBootSpringBootActuatorVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.org.springframework.boot.spring.boot.configuration</b>
         */
        public OrgSpringframeworkBootSpringBootConfigurationVersionAccessors getConfiguration() {
            return vaccForOrgSpringframeworkBootSpringBootConfigurationVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.org.springframework.boot.spring.boot.starter</b>
         */
        public OrgSpringframeworkBootSpringBootStarterVersionAccessors getStarter() {
            return vaccForOrgSpringframeworkBootSpringBootStarterVersionAccessors;
        }

    }

    public static class OrgSpringframeworkBootSpringBootActuatorVersionAccessors extends VersionFactory  {

        public OrgSpringframeworkBootSpringBootActuatorVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.springframework.boot.spring.boot.actuator.autoconfigure</b> with value <b>3.1.4</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getAutoconfigure() { return getVersion("org.springframework.boot.spring.boot.actuator.autoconfigure"); }

    }

    public static class OrgSpringframeworkBootSpringBootConfigurationVersionAccessors extends VersionFactory  {

        public OrgSpringframeworkBootSpringBootConfigurationVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.springframework.boot.spring.boot.configuration.processor</b> with value <b>3.1.4</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getProcessor() { return getVersion("org.springframework.boot.spring.boot.configuration.processor"); }

    }

    public static class OrgSpringframeworkBootSpringBootStarterVersionAccessors extends VersionFactory  implements VersionNotationSupplier {

        private final OrgSpringframeworkBootSpringBootStarterDataVersionAccessors vaccForOrgSpringframeworkBootSpringBootStarterDataVersionAccessors = new OrgSpringframeworkBootSpringBootStarterDataVersionAccessors(providers, config);
        private final OrgSpringframeworkBootSpringBootStarterOauth2VersionAccessors vaccForOrgSpringframeworkBootSpringBootStarterOauth2VersionAccessors = new OrgSpringframeworkBootSpringBootStarterOauth2VersionAccessors(providers, config);
        public OrgSpringframeworkBootSpringBootStarterVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.springframework.boot.spring.boot.starter</b> with value <b>3.1.4</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> asProvider() { return getVersion("org.springframework.boot.spring.boot.starter"); }

        /**
         * Version alias <b>org.springframework.boot.spring.boot.starter.actuator</b> with value <b>3.1.4</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getActuator() { return getVersion("org.springframework.boot.spring.boot.starter.actuator"); }

        /**
         * Version alias <b>org.springframework.boot.spring.boot.starter.security</b> with value <b>3.1.4</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getSecurity() { return getVersion("org.springframework.boot.spring.boot.starter.security"); }

        /**
         * Version alias <b>org.springframework.boot.spring.boot.starter.test</b> with value <b>3.1.4</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getTest() { return getVersion("org.springframework.boot.spring.boot.starter.test"); }

        /**
         * Version alias <b>org.springframework.boot.spring.boot.starter.tomcat</b> with value <b>3.1.4</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getTomcat() { return getVersion("org.springframework.boot.spring.boot.starter.tomcat"); }

        /**
         * Version alias <b>org.springframework.boot.spring.boot.starter.validation</b> with value <b>3.1.4</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getValidation() { return getVersion("org.springframework.boot.spring.boot.starter.validation"); }

        /**
         * Version alias <b>org.springframework.boot.spring.boot.starter.web</b> with value <b>3.1.4</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getWeb() { return getVersion("org.springframework.boot.spring.boot.starter.web"); }

        /**
         * Version alias <b>org.springframework.boot.spring.boot.starter.webflux</b> with value <b>3.1.4</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getWebflux() { return getVersion("org.springframework.boot.spring.boot.starter.webflux"); }

        /**
         * Group of versions at <b>versions.org.springframework.boot.spring.boot.starter.data</b>
         */
        public OrgSpringframeworkBootSpringBootStarterDataVersionAccessors getData() {
            return vaccForOrgSpringframeworkBootSpringBootStarterDataVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.org.springframework.boot.spring.boot.starter.oauth2</b>
         */
        public OrgSpringframeworkBootSpringBootStarterOauth2VersionAccessors getOauth2() {
            return vaccForOrgSpringframeworkBootSpringBootStarterOauth2VersionAccessors;
        }

    }

    public static class OrgSpringframeworkBootSpringBootStarterDataVersionAccessors extends VersionFactory  {

        public OrgSpringframeworkBootSpringBootStarterDataVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.springframework.boot.spring.boot.starter.data.mongodb</b> with value <b>3.1.4</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getMongodb() { return getVersion("org.springframework.boot.spring.boot.starter.data.mongodb"); }

    }

    public static class OrgSpringframeworkBootSpringBootStarterOauth2VersionAccessors extends VersionFactory  {

        private final OrgSpringframeworkBootSpringBootStarterOauth2ResourceVersionAccessors vaccForOrgSpringframeworkBootSpringBootStarterOauth2ResourceVersionAccessors = new OrgSpringframeworkBootSpringBootStarterOauth2ResourceVersionAccessors(providers, config);
        public OrgSpringframeworkBootSpringBootStarterOauth2VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.springframework.boot.spring.boot.starter.oauth2.resource</b>
         */
        public OrgSpringframeworkBootSpringBootStarterOauth2ResourceVersionAccessors getResource() {
            return vaccForOrgSpringframeworkBootSpringBootStarterOauth2ResourceVersionAccessors;
        }

    }

    public static class OrgSpringframeworkBootSpringBootStarterOauth2ResourceVersionAccessors extends VersionFactory  {

        public OrgSpringframeworkBootSpringBootStarterOauth2ResourceVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.springframework.boot.spring.boot.starter.oauth2.resource.server</b> with value <b>3.1.4</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getServer() { return getVersion("org.springframework.boot.spring.boot.starter.oauth2.resource.server"); }

    }

    public static class OrgSpringframeworkCloudVersionAccessors extends VersionFactory  {

        private final OrgSpringframeworkCloudSpringVersionAccessors vaccForOrgSpringframeworkCloudSpringVersionAccessors = new OrgSpringframeworkCloudSpringVersionAccessors(providers, config);
        public OrgSpringframeworkCloudVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.springframework.cloud.spring</b>
         */
        public OrgSpringframeworkCloudSpringVersionAccessors getSpring() {
            return vaccForOrgSpringframeworkCloudSpringVersionAccessors;
        }

    }

    public static class OrgSpringframeworkCloudSpringVersionAccessors extends VersionFactory  {

        private final OrgSpringframeworkCloudSpringCloudVersionAccessors vaccForOrgSpringframeworkCloudSpringCloudVersionAccessors = new OrgSpringframeworkCloudSpringCloudVersionAccessors(providers, config);
        public OrgSpringframeworkCloudSpringVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.springframework.cloud.spring.cloud</b>
         */
        public OrgSpringframeworkCloudSpringCloudVersionAccessors getCloud() {
            return vaccForOrgSpringframeworkCloudSpringCloudVersionAccessors;
        }

    }

    public static class OrgSpringframeworkCloudSpringCloudVersionAccessors extends VersionFactory  {

        private final OrgSpringframeworkCloudSpringCloudFunctionVersionAccessors vaccForOrgSpringframeworkCloudSpringCloudFunctionVersionAccessors = new OrgSpringframeworkCloudSpringCloudFunctionVersionAccessors(providers, config);
        public OrgSpringframeworkCloudSpringCloudVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.springframework.cloud.spring.cloud.function</b>
         */
        public OrgSpringframeworkCloudSpringCloudFunctionVersionAccessors getFunction() {
            return vaccForOrgSpringframeworkCloudSpringCloudFunctionVersionAccessors;
        }

    }

    public static class OrgSpringframeworkCloudSpringCloudFunctionVersionAccessors extends VersionFactory  {

        public OrgSpringframeworkCloudSpringCloudFunctionVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.springframework.cloud.spring.cloud.function.context</b> with value <b>4.1.3</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getContext() { return getVersion("org.springframework.cloud.spring.cloud.function.context"); }

    }

    public static class OrgSpringframeworkDataVersionAccessors extends VersionFactory  {

        private final OrgSpringframeworkDataSpringVersionAccessors vaccForOrgSpringframeworkDataSpringVersionAccessors = new OrgSpringframeworkDataSpringVersionAccessors(providers, config);
        public OrgSpringframeworkDataVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.springframework.data.spring</b>
         */
        public OrgSpringframeworkDataSpringVersionAccessors getSpring() {
            return vaccForOrgSpringframeworkDataSpringVersionAccessors;
        }

    }

    public static class OrgSpringframeworkDataSpringVersionAccessors extends VersionFactory  {

        private final OrgSpringframeworkDataSpringDataVersionAccessors vaccForOrgSpringframeworkDataSpringDataVersionAccessors = new OrgSpringframeworkDataSpringDataVersionAccessors(providers, config);
        public OrgSpringframeworkDataSpringVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.springframework.data.spring.data</b>
         */
        public OrgSpringframeworkDataSpringDataVersionAccessors getData() {
            return vaccForOrgSpringframeworkDataSpringDataVersionAccessors;
        }

    }

    public static class OrgSpringframeworkDataSpringDataVersionAccessors extends VersionFactory  {

        public OrgSpringframeworkDataSpringDataVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.springframework.data.spring.data.commons</b> with value <b>3.1.4</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getCommons() { return getVersion("org.springframework.data.spring.data.commons"); }

    }

    public static class OrgSpringframeworkIntegrationVersionAccessors extends VersionFactory  {

        private final OrgSpringframeworkIntegrationSpringVersionAccessors vaccForOrgSpringframeworkIntegrationSpringVersionAccessors = new OrgSpringframeworkIntegrationSpringVersionAccessors(providers, config);
        public OrgSpringframeworkIntegrationVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.springframework.integration.spring</b>
         */
        public OrgSpringframeworkIntegrationSpringVersionAccessors getSpring() {
            return vaccForOrgSpringframeworkIntegrationSpringVersionAccessors;
        }

    }

    public static class OrgSpringframeworkIntegrationSpringVersionAccessors extends VersionFactory  {

        private final OrgSpringframeworkIntegrationSpringIntegrationVersionAccessors vaccForOrgSpringframeworkIntegrationSpringIntegrationVersionAccessors = new OrgSpringframeworkIntegrationSpringIntegrationVersionAccessors(providers, config);
        public OrgSpringframeworkIntegrationSpringVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.springframework.integration.spring.integration</b>
         */
        public OrgSpringframeworkIntegrationSpringIntegrationVersionAccessors getIntegration() {
            return vaccForOrgSpringframeworkIntegrationSpringIntegrationVersionAccessors;
        }

    }

    public static class OrgSpringframeworkIntegrationSpringIntegrationVersionAccessors extends VersionFactory  {

        public OrgSpringframeworkIntegrationSpringIntegrationVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.springframework.integration.spring.integration.file</b> with value <b>6.1.3</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getFile() { return getVersion("org.springframework.integration.spring.integration.file"); }

    }

    public static class OrgSpringframeworkKafkaVersionAccessors extends VersionFactory  {

        private final OrgSpringframeworkKafkaSpringVersionAccessors vaccForOrgSpringframeworkKafkaSpringVersionAccessors = new OrgSpringframeworkKafkaSpringVersionAccessors(providers, config);
        public OrgSpringframeworkKafkaVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.springframework.kafka.spring</b>
         */
        public OrgSpringframeworkKafkaSpringVersionAccessors getSpring() {
            return vaccForOrgSpringframeworkKafkaSpringVersionAccessors;
        }

    }

    public static class OrgSpringframeworkKafkaSpringVersionAccessors extends VersionFactory  {

        public OrgSpringframeworkKafkaSpringVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.springframework.kafka.spring.kafka</b> with value <b>3.0.11</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getKafka() { return getVersion("org.springframework.kafka.spring.kafka"); }

    }

    public static class OrgSpringframeworkSpringVersionAccessors extends VersionFactory  {

        public OrgSpringframeworkSpringVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.springframework.spring.context</b> with value <b>6.0.12</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getContext() { return getVersion("org.springframework.spring.context"); }

        /**
         * Version alias <b>org.springframework.spring.web</b> with value <b>6.0.12</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getWeb() { return getVersion("org.springframework.spring.web"); }

    }

    public static class OrgXmlunitVersionAccessors extends VersionFactory  {

        private final OrgXmlunitXmlunitVersionAccessors vaccForOrgXmlunitXmlunitVersionAccessors = new OrgXmlunitXmlunitVersionAccessors(providers, config);
        public OrgXmlunitVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.xmlunit.xmlunit</b>
         */
        public OrgXmlunitXmlunitVersionAccessors getXmlunit() {
            return vaccForOrgXmlunitXmlunitVersionAccessors;
        }

    }

    public static class OrgXmlunitXmlunitVersionAccessors extends VersionFactory  {

        public OrgXmlunitXmlunitVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.xmlunit.xmlunit.core</b> with value <b>2.9.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getCore() { return getVersion("org.xmlunit.xmlunit.core"); }

        /**
         * Version alias <b>org.xmlunit.xmlunit.matchers</b> with value <b>2.9.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getMatchers() { return getVersion("org.xmlunit.xmlunit.matchers"); }

    }

    public static class OrgYamlVersionAccessors extends VersionFactory  {

        public OrgYamlVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.yaml.snakeyaml</b> with value <b>2.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getSnakeyaml() { return getVersion("org.yaml.snakeyaml"); }

    }

    public static class BundleAccessors extends BundleFactory {

        public BundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

    }

    public static class PluginAccessors extends PluginFactory {

        public PluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

    }

}
