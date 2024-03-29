Add it in your root build.gradle at the end of repositories:

dependencyResolutionManagement {
		repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
		repositories {
			mavenCentral()
			maven { url 'https://jitpack.io' }
		}
	}
 .....

 dependencies {
	        implementation 'com.github.YogeshVerma31:chat-bot-task:Tag'
	}
