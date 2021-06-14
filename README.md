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
#### 1. 메인 화면
    - 로그인, 회원가입 기능
    - Select box를 이용한 지역 매물 검색 기능
    - 검색어를 이용한 매물명 검색 기능
![메인](https://user-images.githubusercontent.com/66583397/121894146-c1ac2580-cd59-11eb-9e8b-2821eb777d29.JPG)

<br>

#### 2. 회원정보 조회/수정/탈퇴
    - 사용자 정보 조회
    - 사용자 정보 수정 및 회원 탈퇴 가능
![회원관리](https://user-images.githubusercontent.com/66583397/121894834-8f4ef800-cd5a-11eb-90c2-4b47481584d6.JPG)

<br>

#### 3. 매물 리스트 화면
    - 매물명 및 지역별 리스트
    - 페이징 처리
    - column 클릭시 정렬 기능
    
##### 1) 지역별 리스트
    - 관심지역 등록 기능
![지역별 리스트](https://user-images.githubusercontent.com/66583397/121895939-bd810780-cd5b-11eb-9aca-fc47488d26a8.JPG)

##### 2) 매물별 리스트
![매물별 리스트](https://user-images.githubusercontent.com/66583397/121896058-d984a900-cd5b-11eb-9d6c-e56f4cb7f768.JPG)

<br>

#### 4. chart dashboard 화면
    - 매물명 및 지역별 차트
    - 총거래량, 평균 매매가격, 매매 최고가, 매매최저가 표시
    - 1억 ~ 20억 사이의 거래가격 분포 차트
    - 매매타입, 음식지수, 월별 거래량 차트
    
##### 1) 지역별 리스트
![지역별 차트](https://user-images.githubusercontent.com/66583397/121896863-bad2e200-cd5c-11eb-9420-15778a22dfb8.JPG)

##### 2) 매물별 리스트
    - 매물이 가장 많은 지역의 
![매물별 차트](https://user-images.githubusercontent.com/66583397/121896842-b60e2e00-cd5c-11eb-8537-656850638bdd.JPG)

<br>

#### 5. 오늘의 뉴스
    - 네이버 검색 API 사용 실시간 뉴스 검색 기능
    - 키워드 검색, 페이징 처리
    - 뉴스 상세 조회
    - 네이버 뉴스 본문 링크 제공
    - 언론사 본문 링크 제공
![부동산 뉴스 검색 날짜 기준 정렬](https://user-images.githubusercontent.com/62068895/121524911-bfcd2400-ca32-11eb-8dba-18aa7942616c.PNG)
![뉴스 상세 페이지 뉴스 본문 링크 제공](https://user-images.githubusercontent.com/62068895/121524870-b5ab2580-ca32-11eb-8309-1c26ee652cb1.PNG)

<br>

#### 6. 아파트 매물 검색 & 날씨 조회
    - 동 별 검색 시 지도에 아파트 목록을 마커로 조회 가능
    - 화면 우측 상단 부터 ‘지역 정보’ , ‘날씨’ , ‘매물 목록’ 조회 가능
    - 매물 목록에 대한 페이징 처리
![아파트 매물 검색 날씨 조회](https://user-images.githubusercontent.com/62068895/121529567-7df2ac80-ca37-11eb-83e4-dbb9fbe1ac5b.PNG)

<br>

#### 7. 아파트 매물 상세 & 주변 편의시설 조회
    - 매물 목록 아이템 클릭시 , 해당 매물 아파트 상세 목록 조회 가능(가격, 평수, 층 수, 페이징 처리)
    - 해당 매물의 거래가격을 사용자 편의를 생각해 데이터 가공하여 출력
    - 지도 왼쪽 상단 주변 편의시설 마커로 조회 가능
![매물 상세 정보 주변 편의시설 조회](https://user-images.githubusercontent.com/62068895/121529612-8b0f9b80-ca37-11eb-9b1b-be2d80d9da70.PNG)
