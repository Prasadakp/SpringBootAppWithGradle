node{
	stage('SCM Checkout'){
		git 'https://github.com/Prasadakp/SpringBootAppWithGradle.git'
	}
	stage('Build'){
		sh './gradlew clean build '
	}
}