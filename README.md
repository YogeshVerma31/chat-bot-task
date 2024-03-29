#How to add library ib project
Add it in your root build.gradle at the end of repositories:

step 1 > 

dependencyResolutionManagement {
		repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
		repositories {
			mavenCentral()
			maven { url 'https://jitpack.io' }
		}
	}
 ....

 step2 > 
 
 dependencies {
	        implementation 'com.github.YogeshVerma31:chat-bot-task:Tag'
	}
