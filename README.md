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


> Compose에서의 상태
* Compose 앱은 구성 가능한 함수를 호출하여 데이터를 UI로 변환합니다. 데이터가 변경되면 Compose는 새 데이터로 이러한 함수를 다시 실행하여 업데이트된 UI를 만듭니다. 이를 리컴포지션이라고 합니다. 또한, Compose는 데이터가 변경된 구성요소만 다시 구성하고 영향을 받지 않는 구성요소는 다시 구성하지 않고 건너뛰도록 개별 컴포저블에서 필요한 데이터를 확인합니다.
* 컴포저블에 내부 상태를 추가하려면 mutableStateOf 함수를 사용하면 됩니다. 이 함수를 사용하면 Compose가 이 State를 읽는 함수를 재구성합니다.
* 하지만, 컴포저블 내의 변수에 mutableStateOf를 할당하기만 할 수는 없습니다. 앞에서 설명한 것처럼 false 값을 가진 변경 가능한 새 상태로 상태를 재설정하여 컴포저블을 다시 호출하는 때는 언제든지 리컴포지션이 일어날 수 있습니다.
여러 리컴포지션 간에 상태를 유지하려면 remember를 사용하여 변경 가능한 상태를 기억해야 합니다.
* 정리 composable에 변경 가능한 상태를 추가하려면 mutableStateOf를 통해 상태를 나타내고 이때 composable을 통해 mutableStateOf의 새 상태만 받는게 아닌 기존 리컴포지션 상태를 유지하려면 remember를 사용하여 현재 값이 변경된 값인지 판단하도록 한다.


> Compose 상태 호이스팅
* Compose 상태 호이스팅이란 끌어올린다는 뜻을 가지고 있다. 하위 구성요소의 상태값을 상위에서 제어할 수 있도록 한다.
* 람다식을 통해 하위 클릭이벤트 등과 같은 이벤트에 상위의 함수를 전달하여 상위에서 가지고 있는 상태값을 하위에게 전달하는 것이 아닌 하위에서 이벤트가 올라와 상위의 상태값을 컨트롤 한다.
* Ex) onContinueClicked: () -> Unit
* 상태 호이스팅을 사용한다면 상태가 중복되지 않고 버그가 발생하는 것을 방지할 수 있으며 Composable을 재사용 할 수 있다.
