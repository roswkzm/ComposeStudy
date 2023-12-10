# ComposeStudy
## 이 레포지토리에서 제공되는 코드 설명과 예제에는 오류나 부정확한 부분이 있을 수 있습니다. 해당 오류에 대해 오차가 발생할 시 즉시 수정하도록 하겠습니다.

### 개념 알아보기
> @composable
* 컴포즈 UI 뷰를 반환
> @preview
* 컴포즈 UI 미리보기 가능

> Surface
* 배경 색상 설정
* Ex) Text의 배경을 넣고싶다면 Surface로 Text를 래핑한다.

> modifier
* Surface 및 Text와 같은 대부분의 ComposeUI 요소는 modifier 매개변수를 선택적으로 허용한다.
* 수정자는 상위요소 레이아웃 내에서 UI 요소가 배치되고 표시되고 동작하는 방식을 UI에 알린다.
* Ex) padding을 주고싶다면 Modifier.padding()과 같이 수정자를 만들 수 있다.

> scafFold
* Material 디자인을 가져올 수 있음(AppBar, Floatting Button 등)


> Row()
* Horizontal LinearLayout과 유사 
* () 안에는 Modifier 속성을 통해 padding, margin, background, verticalScroll, fillMaxwidth 등 Composable의 속성 변경 가능함.

> Column()
* Vertical LinearLayout과 유사
* () 안에는 Modifier 속성을 통해 padding, margin, background, horizontalScroll, fillMaxwidth 등 Composable의 속성 변경 가능함.

> LazyColumn, LazyRow
* RecyclerView와 유사
* Row나 Column의 Arrangement를 통해 해당 Item의 옵션 설정 가능
* Text의 Style 속성에서 typography 속성을 통해 theme 통합관리 가능

> Box
* 뷰를 겹칠 때 사용한다.
* ConstriantLayout에서 뷰 겹치던거 생각하면 편함
* alignment 속성을 통해 위치를 지정할 수 있다.
* <table>
    <tr>
        <th> </th>
        <th>위</th>
        <th>중간</th>
        <th>아래</th>
    </tr>
    <tr>
        <td>시작</td>
        <td>top start</td>
        <td>center start</td>
        <td>bottom start</td>
    </tr>
    <tr>
        <td>중앙</td>
        <td>top center</td>
        <td>center</td>
        <td>bottom center</td>
    </tr>
    <tr>
        <td>끝</td>
        <td>top end</td>
        <td>center end</td>
        <td>bottom end</td>
    </tr>
 </table>



> BoxWithConstraints
* BoxWithConstraintsScope가 생김
* this.minHeight 또는 width 등을 통해 해상도별 대응 가능?
