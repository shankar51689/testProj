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
    productFlavors {
        register("foo") {
            dimension = "default" // Assign to the dimension
            aarMetadata {
                minCompileSdk = 30
            }
        }
    }

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
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}


publishing {
    publications {
        create<MavenPublication>("release") {
            groupId = "com.example.myproject"
            artifactId = "mylibrary"
            version = "1.0.2"

            pom {
                name.set("My Library")
                description.set("A brief description of your project.")
                url.set("http://example.com/my-library")

                licenses {
                    license {
                        name.set("The Apache License, Version 2.0")
                        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }

                developers {
                    developer {
                        id.set("developer_id")
                        name.set("Your Name")
                        email.set("your_email@example.com")
                    }
                }

                scm {
                    connection.set("scm:git:git://example.com/my-library.git")
                    developerConnection.set("scm:git:ssh://example.com/my-library.git")
                    url.set("http://example.com/my-library")
                }
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