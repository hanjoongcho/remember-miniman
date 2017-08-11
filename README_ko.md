# :bulb: Remember Mini Man
[![License][licensesvg]][LICENSE.md] <br />
기억력을 이용하는 간단한 게임입니다. <br />
안드로이드 프로그램 개발을 시작하는 개발자들을 위해서 주요 안드로이드 lib들을 매쉬업하여 간단한 게임을 만들었습니다.
<a href='https://play.google.com/store/apps/details?id=me.blog.korn123.rememberminiman'><img alt='Get it on Google Play' src='https://play.google.com/intl/en_us/badges/images/generic/en_badge_web_generic.png' width="323" height="125"/></a><br />
[README of English][README_en.md]

# 게임방법
```
Step1. Miniman을 순서대로 기억한다.
       stage1: 3명의 Miniman을 기억해야함
       stage2: 5명의 Miniman을 기억해야함
       stage3: 8명의 Miniman을 기억해야함
```
<img src="screenshots/memorize_1.gif" width="288" height="512">&nbsp;
<img src="screenshots/memorize_2.png" width="288" height="512">&nbsp;
<img src="screenshots/memorize_3.png" width="288" height="512">

```
Step2. Miniman을 순서대로 선택한다.
```
<img src="screenshots/play_1.png" width="288" height="512">&nbsp;
<img src="screenshots/play_2.png" width="288" height="512">


```
Step3. 3번의 게임이 모두 끝날때까지 동일한 방법으로 반복한다.
       최종 기록은 3번의 게임을 진행하는동안 소요된 시간의 합계다.
       Firebase Realtime Database를 이용한 랭킹등록기능은 추후에 만들 예정이다.
```
<img src="screenshots/play_3.png" width="288" height="512">&nbsp;
<img src="screenshots/play_4.png" width="288" height="512">&nbsp;
<img src="screenshots/play_5.png" width="288" height="512">&nbsp;

# 빌드방법
```
Step1. 'remember-miniman' 프로젝트를 포크한다.
Step2. 안드로이드 스튜디오에서 'remember-miniman' 프로젝트를 임포트한다.
Step3. 아래 링크를 이용해서 svg 이미지를 Flaticon 사이트에서 다운로드한다.
Step4. 선호하는 20개의 svg 이미지를 선택해서 아래 예시처럼 파일명을 변경한다.
       ex> miniman_1.svg, miniman_2.svg, ..., miniman_19.svg, miniman_20.svg
Step5. 이름이 변경된 20개의 svg이미지를 '/app/src/main/res/raw' 디렉토리에 복사한다.
Step6. Firebase 콘솔에서 프로젝트를 생성한다.(https://firebase.google.com/)
Step7. Firebase 콘솔에서 'google-services.json' 파일을 다운로드 후 '/remember-miniman/app/' 디렉토리에 복사한다.
Step8. 안드로이드 스튜디오에서 'remember-miniman' 프로젝트를 빌드한다.
```
[Flaticon 사이트에서 svg images 다운받기][1]

# 라이선스
[LICENSE][LICENSE.md]

[1]: https://www.flaticon.com/packs/miniman
[licensesvg]: https://img.shields.io/badge/License-Apache--2.0-brightgreen.svg
[README_en.md]: https://github.com/hanjoongcho/remember-miniman/blob/master/README_ko.md
[LICENSE.md]: https://github.com/hanjoongcho/remember-miniman/blob/master/LICENSE.md