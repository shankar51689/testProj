plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    id ("maven-publish")
}

android {
    namespace = "com.example.mylibrary"
    compileSdk = 35
    flavorDimensions += "default"

    defaultConfig {
        minSdk = 24

        aarMetadata {
            minCompileSdk = 24
        }
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    // Assign the flavor to the "default" dimension
    /*productFlavors {
        register("foo") {
            dimension = "default" // Assign to the dimension
            aarMetadata {
                minCompileSdk = 30
            }
        }
    }*/

    publishing {
        singleVariant("release") {
            withSourcesJar()
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }

        /*create("customFoo") {
            isMinifyEnabled = false
//            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }*/
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }

    sourceSets {
        getByName("main").java.srcDirs("src/main/java")
    }
}

tasks.register<Jar>("sourcesJar") {
    archiveClassifier.set("sources")
//    from(sourceSets["main"].allSource)
    from(android.sourceSets["main"].java.srcDirs)
}


publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            groupId = "com.example.mylibrary"
            artifactId = "mylibrary"
            version = "1.0.0"

            // Add artifacts
            artifact(tasks.getByName("sourcesJar"))
            artifact("${layout.buildDirectory}/outputs/aar/mylibrary-release.aar")

            // Configure POM details
            pom {
                name.set("My Library")
                description.set("A sample Android library.")
                url.set("https://example.com/mylibrary")
                licenses {
                    license {
                        name.set("The Apache License, Version 2.0")
                        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }
            }
            /*jar {
                archiveBaseName.set("my-library")  // Name of the jar file
                archiveVersion.set("1.0.0")        // Version of the jar file
                from( sourceSets.main.output )       // Specify which files should be included in the jar
            }*/
        }
    }

    repositories {
        maven {
//            name = "myMavenRepo"
            url = uri("https://oss.sonatype.org/service/local/staging/deploy/maven2/")
            credentials {
                username = "monu40128@gmail.com"
                password = "Monu@5168900"
            }
        }
    }
}




/*publishing {
    publications {
        // Use AndroidLibrary instead of MavenPublication
        create<MavenPublication>("release") {
            groupId = "com.github.shankar51689" // Define your groupId
            artifactId = "mylibrary" // Define your artifactId
            version = "1.0.0" // Define your version
        }
    }
    repositories {
        mavenLocal()
        maven {
            url = uri("https://github.com/shankar51689/testProj.git") // Replace with your repository URL
            *//*credentials {
                username = (project.findProperty("mavenUser") ?: System.getenv("MAVEN_USER")).toString()
                password = (project.findProperty("mavenPassword") ?: System.getenv("MAVEN_PASSWORD")).toString()
            }*//*
        }
    }
}*/


dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.cardview)
//    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation ("com.github.jitpack:android-example:1.0.1")
}