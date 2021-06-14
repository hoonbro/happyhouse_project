# 🏡 Happy House
부동산 반응형 웹 사이트

<br>

## 개발 기간 📆
* 2021년 5월 20일 ~ 5월 27일

<br>

## Tech Stack
### Frontend
    Vue.js
### Backend
    Spring boot, RestAPI
### Database
    MySQL

<br>

## 화면 설계
### 1. 메인 화면
    - 로그인, 회원가입 기능
    - Select box를 이용한 지역 매물 검색 기능
    - 검색어를 이용한 매물명 검색 기능
![메인](https://user-images.githubusercontent.com/66583397/121894146-c1ac2580-cd59-11eb-9e8b-2821eb777d29.JPG)

<br>

### 2. 회원정보 조회/수정/탈퇴
    - 사용자 정보 조회
    - 사용자 정보 수정 및 회원 탈퇴 가능
![회원관리](https://user-images.githubusercontent.com/66583397/121894834-8f4ef800-cd5a-11eb-90c2-4b47481584d6.JPG)

<br>

### 3. 매물 리스트 화면
    - 매물명 및 지역별 리스트
    - 매물 리스트 페이징 처리
    - column 클릭시 정렬 기능
    
#### 1) 지역별 리스트
    - 관심지역 등록 기능
![지역별 리스트](https://user-images.githubusercontent.com/66583397/121895939-bd810780-cd5b-11eb-9aca-fc47488d26a8.JPG)

#### 2) 검색어별 리스트
![매물별 리스트](https://user-images.githubusercontent.com/66583397/121896058-d984a900-cd5b-11eb-9d6c-e56f4cb7f768.JPG)

<br>

### 4. chart dashboard 화면
    - 매물명 및 지역별 차트
    - 총거래량, 평균 매매가격, 매매 최고가, 매매최저가 표시
    - 1억 ~ 20억 사이의 거래가격 분포 차트(전체, 시/군/구, 동)
    - 매매타입 Pie Chart(아파트, 연립주택, 오피스텔)
    - 주변상권 bar Chart(치킨, 피자, 편의점 카페)
    - 월별 거래량 Chart
    
#### 1) 지역별 리스트
![지역별 차트](https://user-images.githubusercontent.com/66583397/121896863-bad2e200-cd5c-11eb-9420-15778a22dfb8.JPG)

#### 2) 검색어별 리스트
    - 검색어와 같은 매물이 가장 많은 지역으로 검색
![매물별 차트](https://user-images.githubusercontent.com/66583397/121896842-b60e2e00-cd5c-11eb-8537-656850638bdd.JPG)

<br>

### 5. 지도 화면
    - kakao map api 사용
    - 검색지역으로 지도 이동 및 마커를 이용한 매물 표시
    - 마커 클릭시 매물 상세정보 표시(거래가, 층수, 거래일 등)
    - 마커 제목 클릭시 구글 이미지 검색
    
#### 1) 지역별 지도 표시
![지역검색 지도](https://user-images.githubusercontent.com/66583397/121898061-f5894a00-cd5d-11eb-93af-040557fcaf29.JPG)

#### 2) 검색어별 지도 표시
    - 검색어와 같은 매물이 가장 많은 지역으로 검색
    - 검색어와 같은 매물 모두 
![매물검색 지도](https://user-images.githubusercontent.com/66583397/121898730-a68fe480-cd5e-11eb-8fb1-8ad20e65d8af.JPG)

<br>

### 7. 관심지역 목록
    - 지역별 리스트 화면에서 버튼 클릭시 관심지역 등록
    - 버튼클릭시 관심지역 삭제 기능
    - table row 클릭시 지역 검색 기능
![찜목록](https://user-images.githubusercontent.com/66583397/121900788-c58f7600-cd60-11eb-9b74-87224dcf2089.JPG)

