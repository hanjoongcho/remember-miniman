# :bulb: Remember Mini Man
[![License][licensesvg]][license] <br />
기억력을 이용하는 간단한 게임입니다. <br />
안드로이드 프로그램 개발을 시작하는 개발자들을 위해서 주요 안드로이드 lib들을 매쉬업하여 간단한 게임을 만들었습니다.
<a href='https://play.google.com/store/apps/details?id=me.blog.korn123.rememberminiman'><img alt='Get it on Google Play' src='https://play.google.com/intl/en_us/badges/images/generic/en_badge_web_generic.png' width="323" height="125"/></a><br />

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

# How to build
```
Step1. 'remember-miniman' 프로젝트를 포크한다.
Step2. 안드로이드 스튜디오에서 'remember-miniman' 프로젝트를 임포트한다.
Step3. 아래 링크를 이용해서 svg 이미지를 Flaticon사이트에서 다운로드한다.
Step4. 선호하는 20개의 svg 이미지를 선택해서 아래 예시처럼 파일명을 변경한다.
       ex> miniman_1.svg, miniman_2.svg, ..., miniman_19.svg, miniman_20.svg
Step5. 이름이 변경된 20개의 svg이미지를 '/app/src/main/res/raw' 디렉토리에 복사한다.
Step6. 안드로이드 스튜디오에서 'remember-miniman' 프로젝트를 빌드한다.
```
[Download miniman svg images from Flaticon][1]

# License

### remember-miniman
Copyright 2017 Hanjoong Cho (https://github.com/hanjoongcho/remember-miniman)
```
Copyright 2017 Hanjoong Cho

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

### svg images
Flaticon Basic License (https://www.flaticon.com/packs/miniman)
```
LICENSE TERMS AND CONDITIONS
FREE LICENSE (WITH ATTRIBUTION)
This license allows you to use for free any of Flaticon contents for your projects as long as they are
attributed to their author in the definitive project".
How to attribute contents?
- For web usage: By placing a link with the text "designed by {Author's Name} from Flaticon" in a visible
spot, so the author's authorship is noticeable.
- Uses different to web: If possible, the text "designed by {Author's Name} from Flaticon" must be written
next to Flaticon Contents, if it's not possible, the attribution must be placed in the credits or
acknowledgements section.
Where you can use Flaticon contents:
- Website.
- Software, applications, mobile, Multimedia
- Printed and digital media (magazines, newspapers, books, cards, labels, CD, television, video, e-mail).
- Advertisement and promotional items.
- Presentation of products and public events.
What you CAN DO:
- You have the non-exclusive, non-transferable, non-sublicensable right to use the licensed material an
unlimited number of times in any and all media for the commercial or personal purposes listed above.
- You may alter and create derivative works.
- You can use Flaticon Contents during the rights period world widely.
What you CAN NOT DO:
- Sublicense, sell or rent any contents (or a modified version of them).
- Distribute Flaticon Contents unless it has been expressly authorized by Flaticon.
- Include Flaticon Contents in an online or offline database or file.
- Offering Flaticon Contents designs (or modified Flaticon Contents versions) for download.
The complete content of licenses can be consulted on the Terms of Use, that will prevail over the content
of this document.
Graphic Resources S.L
Commercial Registry of Málaga, volume 4994, sheet 217, page number MA-113059, with Tax Number B-
93183366 and registered office at 13 Molina Lario Street, 5th floor, 29015 Málaga, Spain.
```

### ttf fonts
Copyright (c) 2010, NAVER Corporation (http://www.nhncorp.com)
```
Copyright (c) 2010, NAVER Corporation (http://www.nhncorp.com),
with Reserved Font Name Nanum, Naver Nanum, NanumGothic, Naver NanumGothic, NanumMyeongjo, Naver NanumMyeongjo, NanumBrush, Naver NanumBrush, NanumPen, Naver NanumPen, Naver NanumGothicEco, NanumGothicEco, Naver NanumMyeongjoEco, NanumMyeongjoEco, Naver NanumGothicLight, NanumGothicLight, NanumBarunGothic, Naver NanumBarunGothic,
This Font Software is licensed under the SIL Open Font License, Version 1.1.
This license is copied below, and is also available with a FAQ at: http://scripts.sil.org/OFL
SIL OPEN FONT LICENSE
Version 1.1 - 26 February 2007
```

### android-pathview
Copyright 2016 Georgi Eftimov (https://github.com/geftimov/android-pathview)
```
Copyright 2016 Georgi Eftimov

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

### butterknife
Copyright 2013 Jake Wharton (https://github.com/JakeWharton/butterknife)
```
Copyright 2013 Jake Wharton

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

### commons-lang
Apache License Version 2.0, January 2004(https://github.com/apache/commons-lang)
```
Code is under the Apache Licence v2.
```

[1]: https://www.flaticon.com/packs/miniman
[licensesvg]: https://img.shields.io/badge/License-Apache--2.0-brightgreen.svg
[license]: https://github.com/hanjoongcho/remember-miniman/blob/master/LICENSE.md