# 🎬 SABASCRIPT｜OTTプラットフォーム
> 日本語＆プログラミングスキルの学習に特化した動画コミュニティサイト

---

## 📌 プロジェクト概要
**SABASCRIPT** は、日本語学習者やIT業界志望者のための学習支援型OTTプラットフォームです。  
JLPT学習法、日本のIT企業で使われるビジネス用語、開発Tipsなどをテーマとした動画コンテンツを提供し、  
**視聴・レビュー・スクラップ**などの機能を通じて、ユーザー同士のナレッジシェアと学習促進を支援します。

---

## 👥 制作情報
- 開発期間：2025年3月（約4週間）
- 開発メンバー：2名

| 名前 | メールアドレス |
|------|----------------|
| Park Sion（パク・シオン） | psw0097@hanyang.ac.kr |
| Kim Hojun（キム・ホジュン） | cardiacline@gmail.com |

---

## 👨‍🎓 想定ユーザー
- 日本語＆ITスキルを効率的に学びたい方
- 日本企業への就職を目指す外国人エンジニア
- JLPT対策やビジネス日本語を実践的に習得したい方

---

## 🛠 技術スタック
### Frontend（フロントエンド）
![HTML5](https://img.shields.io/badge/html5-E34F26?style=for-the-badge&logo=html5&logoColor=white)
![CSS3](https://img.shields.io/badge/css-1572B6?style=for-the-badge&logo=css3&logoColor=white)
![Sass](https://img.shields.io/badge/sass-CC6699?style=for-the-badge&logo=sass&logoColor=white)
![JavaScript](https://img.shields.io/badge/javascript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black)

### Backend（バックエンド）
![Java](https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white) v1.8  
![Spring](https://img.shields.io/badge/spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white) v5.3.26  
![Apache Maven](https://img.shields.io/badge/apachemaven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white) v3.8.1  
![Apache Tomcat](https://img.shields.io/badge/apache%20tomcat-333333?style=for-the-badge&logo=apachetomcat&logoColor=white) v9.0  

### Database（データベース）
![Oracle](https://img.shields.io/badge/oracle-F80000?style=for-the-badge&logo=oracle&logoColor=white) v21c

---
 
## 🧩 主な機能
| 機能 | 内容 |
|------|------|
| 🔐 ユーザー認証 | 会員登録、ログイン、ログアウト |
| 🎞 コンテンツ閲覧 | 動画リスト、詳細ページ、視聴ページ |
| ❤️ スクラップ機能 | 気に入った動画をスクラップ（保存） |
| 💬 コメント機能 | 各動画へのレビュー投稿／削除／一覧表示 |
| 🍪 Remember Me | ログイン時にID保存可能（クッキー使用） |

## 🖥️ 画面設計（一部）

>Main Visual

![Image](https://github.com/user-attachments/assets/9ca05b5a-4ace-4c6d-b0ab-bd204afe36f4)

>Contents List

![Image](https://github.com/user-attachments/assets/daffdd32-707e-42f3-a279-12296eaf22ed)

>Join Membership

![Image](https://github.com/user-attachments/assets/bca96d78-0690-4b83-951e-e6175803b316)

>Login

![Image](https://github.com/user-attachments/assets/6d3feb52-c4fc-405b-93e1-4fe4c430fce1)

>Scrap

![Image](https://github.com/user-attachments/assets/0cabce9e-43d1-4723-8597-13fbfbc49245)

---

## 📊 DBモデリング（ERD）


---

## 💡 学び・工夫点

- JSP / JSTL / EL を活用した MVCベースのビュー構成を実践
  - 画面レンダリング、条件分岐、反復処理などを JSTL タグと Expression Language を使って効率的に実装
  - Flash属性やCookieなどを用いたセッション／リクエスト管理を経験

- 「Remember Me」機能の実装を通じて、セッションとクッキーの使い分けを学習  
  - チェック状態に応じてユーザーIDをクッキーに保存／削除し、次回ログイン時に自動入力  
  - Flash属性＋`<c:if>`＋`requestScope` を用いたエラー表示処理でUXを改善
 
- OracleのRDB構造に基づき、正規化を意識したテーブル設計を実施
- MyBatisを用いてSQLとJavaオブジェクト（VO）間のマッピング処理を実装

---

## 📌 補足情報

- GitHubでのデモ用プロジェクトです（未デプロイ）
- ポートフォリオ目的のため、動画アップロード機能は静的サンプルで代用しています

---

## 📬 連絡先

- Park Sion（パク・シオン）｜psw0097@hanyang.ac.kr

---
