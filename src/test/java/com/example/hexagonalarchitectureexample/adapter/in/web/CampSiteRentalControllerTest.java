package com.example.hexagonalarchitectureexample.adapter.in.web;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.syntax.elements.ClassesShouldConjunction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = {"com.example.hexagonalarchitectureexample.adapter.in.web"})
class CampSiteRentalControllerTest {

    @Nested
    class ArchitectureRuleTest {
        private JavaClasses importedClasses;

        @BeforeEach
        void archTestSetup() {
            importedClasses = new ClassFileImporter().importPackages("com.example.hexagonalarchitectureexample");
        }

        @ArchTest
        @DisplayName("UseCase must be depended on adapter in web")
        public final void useCaseMustBeDependedOnAdapterInWeb() {
            ClassesShouldConjunction rule = classes().that().resideInAnyPackage("..usecase..")
                    .should().dependOnClassesThat().resideInAnyPackage("..adapter.in.web..");
            rule.check(importedClasses);
        }
    }
}