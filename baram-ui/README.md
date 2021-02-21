# AMIVUE 프로젝트

> **필자가 전하는말:**
> - 사람이 개발하는것이기에 로봇도 아니고 항상 100% 완벽한 통일성을 보장할 수는 없습니다. 그래도 코드를 최대한 맞춰서 작업을 해야한다고 판단되는 부분입니다.
> - 필자가 100% 정답이라고 볼 수는 없습니다. 단지, 아래의 규칙 기준하에 개발되었다는 기준으로 문서를 참고하면 참고하시기 바랍니다.
> - WEB에서 지켜야할 부분이 많습니다. 이는 개발제약을 두기 위함이 아닌 JAVA처럼 문법 체크가 되지 않다보니 중구난방으로 작성되는 코드를 최소한으로 정규화 시키기위함으로 바라봐주셨으면 좋겠습니다.
> - 필자 역시 최대한 아래와 같은 규칙들을 지키려고 노력할 것이고 놓칠수도 있습니다. **비판은 할수 있되 비난은 자제** 부탁드리며 글을 마칩니다.   darka87@kakao.com
> - **본글을 메모장 및 기타 프로그램에 열으셨다면 https://stackedit.io/editor 에다가 복사 붙여넣기 하여 읽으시길 바랍니다.**
---

## 1. Git 사용법
- URL 접속 : [AMIweb](https://github.com/darkness87/AMIWeb)
  ```diff
  !  GIT 저장소 : https://github.com/darkness87/AMIWeb.git
  ※ GIT 사용방식은 각종 플러그인이나 Tortoise GIT 그리고 기타 프로그램을 자유롭게 사용한다.
  필자는 Tortoise Git 사용함
  ```

- 내려받기 : 아이디와 비밀번호는 가입해야 사용가능하다. (가입후 소스 관리자에게 권한을 발급받을 것)

  ![image](https://user-images.githubusercontent.com/20449373/108337118-1f02f080-7218-11eb-9091-2f5e6042c026.png)

## 2. VS CODE 사용법
  > - VS CODE는 이클립스보다 가벼워서 개발하기가 더 수월하다 판단 이를 적용하기 위한 가이드를 제시한다.
  > - 네이버나 다음 각종 포털 사이트에서 검색만해도 공식 홈페이지에서 무료로 다운 받을수 있으므로 참고한다.
- Visual Studio Code 확장 목록

  VSCODE에서 개발하기 편리한 도구들을 플러그인식으로 설치가능하며 필자가 사용한기준을 다운받는걸 권장한다.   
  19개중 'Vue VS Code Extension Pack'은 10개를 묶음 설치이므로 선행 다운로드 하고 부족한 부분을 찾아서 내려받는다.

  |마켓플레이스 다운목록1|마켓플레이스 다운목록2|
  |:----------------:|:----------------:|
  |<img src="https://user-images.githubusercontent.com/20449373/108445729-3ab1d980-72a0-11eb-8706-d83fc1c2dcec.png" width="100%" style="border: 1px solid black; border-radius: 5px;" title="Tortoise GIT 저장소 생성화면"></img> | <img src="https://user-images.githubusercontent.com/20449373/108445803-60d77980-72a0-11eb-9e2f-9b086c515716.png" width="100%" style="border: 1px solid black; border-radius: 5px;" title="저장소 다운로드"></img>|

- 개발서버 구동

  개발서버 구동에 앞서서 node_modules의존성 체크 및 내려받기를 하기위해 다음과 같이 진행한다.
  
  VS CODE는 터미널을 내부제공해주며 창은 단축키 ctrl + ` 혹은 메뉴에 터미널을 통해 직접 열수 있다.
  ```
  npm ci			// 의존성 모듈 다운
  npm run serve	// 개발서버 구동
  ```
  npm install이 아닌 ci를 사용하는 이유는 install은 최신버전을 적용할 수 있어 각 개발자마다 사용하는 버전이 달라질 수 있다.   
  그러므로 ci를 통해 모두 일괄적인 버저닝 관리를 하기 위함이다. 실제로 필자는 다른PC에서 똑같이 구성하는 도중 정상적으로 작동하지 않는 문제가 발생하였었고, 이는 버전이 맞지 않아 정상적으로 수행되지 않는 것으로 확인되었고 이를 정리할 필요가 있었다.   
  필요시 package.json에서 관리된 모듈 수정시 package-lock.json까지 통일 시켜 커밋해주길 권고한다.

- 코드 룰

  코드룰은 기본적으로 eslint + prettier로 구성되어 작성되었으며, 소스 관리는 prettier 우선순위로 적용할 수 있는 룰을 작성할 수 있도록 유도해준다. 추가 필요시엔 개발자들끼리 검토를 통해 추진하는것이 올바른 습관이다.

  ```jsonc
  .prettierrc 발췌
  {
	"arrowParens": "avoid", // 화살표 함수 괄호 사용 방식
	"bracketSpacing": false, // 객체 리터럴에서 괄호에 공백 삽입 여부 
	"endOfLine": "auto", // EoF 방식, OS별로 처리 방식이 다름 
	"htmlWhitespaceSensitivity": "css", // HTML 공백 감도 설정
	"jsxBracketSameLine": false, // JSX의 마지막 `>`를 다음 줄로 내릴지 여부 
	"jsxSingleQuote": false, // JSX에 singe 쿼테이션 사용 여부
	"printWidth": 80, //  줄 바꿈 할 폭 길이
	"proseWrap": "preserve", // markdown 텍스트의 줄바꿈 방식 (v1.8.2)
	"quoteProps": "as-needed", // 객체 속성에 쿼테이션 적용 방식
	"semi": true, // 세미콜론 사용 여부
	"singleQuote": true, // single 쿼테이션 사용 여부
	"tabWidth": 2, // 탭 너비 
	"trailingComma": "all", // 여러 줄을 사용할 때, 후행 콤마 사용 방식
	"useTabs": false, // 탭 사용 여부
	"vueIndentScriptAndStyle": true, // Vue 파일의 script와 style 태그의 들여쓰기 여부 (v1.19.0)
	"parser": '', // 사용할 parser를 지정, 자동으로 지정됨
	"filepath": '', // parser를 유추할 수 있는 파일을 지정
	"rangeStart": 0, // 포맷팅을 부분 적용할 파일의 시작 라인 지정
	"rangeEnd": Infinity, // 포맷팅 부분 적용할 파일의 끝 라인 지정,
	"requirePragma": false, // 파일 상단에 미리 정의된 주석을 작성하고 Pragma로 포맷팅 사용 여부 지정 (v1.8.	0)
	"insertPragma": false, // 미리 정의된 @format marker의 사용 여부 (v1.8.0)
	"overrides": [ 
		{
			"files": "*.json",
			"options": {
			  "printWidth": 200
			}
		}
	], // 특정 파일별로 옵션을 다르게 지정함, ESLint 방식 사용
  }
  ```
  추가적으로 vscode가 있다. vscode에서 prettier가 안정적으로 사용되기 위해서는 다음과같은 필수옵션들이 존재하며 모든 개발자에게 동일한 환경제공을 위해 프로젝트 내에 **.vscode**폴더에서 옵션값들이 관리되고 있다. 이 또한 추가수정이 필요할 경우 개발자들간에 검토를 통해 진행하길 권장한다.
  ```jsonc
  .vscode/settings.json 내용 발췌
  {
	"editor.codeActionsOnSave": {
		// For ESLint
		"source.fixAll.eslint": true
	},
	"editor.formatOnSave": false,
	"[vue]": {
		"editor.defaultFormatter": "esbenp.prettier-vscode"
	},
  }
  ```
  정상적으로 수행이 마쳐지면 코딩 수행시 (저장, 붙여넣기) 자동 formatting이 이루어 지며 개발 패턴을 통일화가 가능해진다.
  ![dev1](https://user-images.githubusercontent.com/20449373/108466522-1d443600-72c7-11eb-9b4b-9ac93cf38bec.gif)

### Customize configuration
See [Configuration Reference](https://cli.vuejs.org/config/).
