# Automation mobile testing with [Appium](https://appium.io/)


___

## Technology stack:

<p  align="center">

<code>
<img width="5%" title="Java" src="forReadme/Java_icon.png">
<img width="5%" title="Gradle" src="forReadme/Gradle_icon.svg">
<img width="5%" title="JUnit5" src="forReadme/JUnit5_icon.png">
<img width="5%" title="IntelliJ IDEA" src="forReadme/Intellij_icon.png">
<img width="5%" title="Selenide" src="forReadme/Selenide_icon.svg">
<img width="5%" title="Github" src="forReadme/Github_icon.png">
<img width="5%" title="Rest Assured" src="forReadme/Rest Assured.png">
<img width="5%" title="Allure_Report" src="forReadme/Allure_Report_icon.svg">
<img width="5%" title="Appium" src="forReadme/appium_icon.png">
</code>
</p>


___

## Run tests from terminal locally:

```bash
gradle clean test -Dtag=browserstack

gradle clean test -Dtag=local_android

gradle clean test -Dtag=Sample
```
___

## Description:

This project was created as an example of developing mobile autotests using the Appium server.

___

## Technical task

1. Установить android studio https://developer.android.com/studio

2. Прописать path:

Параметры Path:

Windows:

%ANDROID_HOME%\tools

%ANDROID_HOME%\tools\bin

%ANDROID_HOME%\platform-tools

Одной строкой, можно скопировать и добавить в конец Path: ;%ANDROID_HOME%\tools;%ANDROID_HOME%\tools\bin;%ANDROID_HOME%\platform-tools

Mac:

$ANDROID_HOME/tools

$ANDROID_HOME/tools/bin

$ANDROID_HOME/platform-tools

Одной строкой, можно скопировать и добавить в .bash_profile:

export PATH=”${PATH}:/$ANDROID_HOME/tools:/$ANDROID_HOME/tools/bin:/$ANDROID_HOME/platform-tools”

3. Установить appium desktop https://github.com/appium/appium-desktop

4. В android studio -> SDK Manager скачать 11 андроид (если не скачан по умолчанию)

5. В AVD Manager скачать образ Pixel 4 для 11 андроида (если не скачан по умолчанию)

6. Запустить эмулятор телефона, опробовать кнопки и функционал

7. Открыть Appium Desktop, запустить server, проконектиться к эмулятору

8. Открыть в appium desktop инспектор, изучить его функционал, попробовать найти локатор

9. Разработать автотест на getting started в приложении википедии - пройти по 4м экранам, на каждом сделать проверку

10. Доработать возможность запуска на разных стендах (передать из командной строки -DdeviceHost=browserstack / selenoid / emulation / real

Для каждого сделать драйвер и конфиг с owner

---

## Materials:

[Appium](https://appium.io/)

[android studio](https://developer.android.com/studio)

[Learning example](https://github.com/qa-guru/wikipedia-mobile-tests/tree/local)

[Ran simple app](https://app-live.browserstack.com/)

[Presentation](https://www.youtube.com/watch?v=6R48jJ1h8nU)

[For example iOS on Swift](https://swiftwithmajid.com/2021/03/18/ui-testing-in-swift-with-xctest-framework/)