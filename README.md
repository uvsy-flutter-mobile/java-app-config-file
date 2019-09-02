# Java App Config File
[![License: GPL v3](https://img.shields.io/badge/License-GPLv3-blue.svg)](https://www.gnu.org/licenses/gpl-3.0)
[![Build Status](https://travis-ci.com/uvsy-flutter-mobile/java-app-config-file.svg?branch=master)](https://travis-ci.com/uvsy-flutter-mobile/java-app-config-file)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/21501c1697b243ca98fc8dd4e839c77d)](https://app.codacy.com/app/info.universy/java-app-config-file?utm_source=github.com&utm_medium=referral&utm_content=uvsy-flutter-mobile/java-app-config-file&utm_campaign=Badge_Grade_Dashboard)
[![Maintainability](https://api.codeclimate.com/v1/badges/c4f8d07ecc0e8e4d759b/maintainability)](https://codeclimate.com/github/uvsy-flutter-mobile/java-app-config-file/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/c4f8d07ecc0e8e4d759b/test_coverage)](https://codeclimate.com/github/uvsy-flutter-mobile/java-app-config-file/test_coverage)

## Java application that downloads and install the configuration file for the mobile application


### To compile:
`./gradlew clean build`

### To run 

`java -jar java-app-config-file-1.0.jar <stage>` 

> Where `<stage>` is the stage from which you want the configuration file

The program fetches the configuration file and outputs it in the following path from which is run 

`./config/config.json`

