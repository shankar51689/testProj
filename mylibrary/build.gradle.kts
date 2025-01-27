plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    id ("maven-publish")
}

android {
    namespace = "com.example.mylibrary"
    compileSdk = 35

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}


publishing {
    publications {
        // Use AndroidLibrary instead of MavenPublication
        create<MavenPublication>("debug") {
            groupId = "com.example" // Define your groupId
            artifactId = "designsystem" // Define your artifactId
            version = "1.0.0" // Define your version
        }
    }
    repositories {
        maven {
            url = uri("https://your-repo.com/repository/maven-releases/") // Replace with your repository URL
            /*credentials {
                username = (project.findProperty("mavenUser") ?: System.getenv("MAVEN_USER")).toString()
                password = (project.findProperty("mavenPassword") ?: System.getenv("MAVEN_PASSWORD")).toString()
            }*/
        }
    }
}


dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
//    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}