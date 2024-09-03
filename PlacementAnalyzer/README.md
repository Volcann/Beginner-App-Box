## Project Overview: Student Placement Prediction App

This project involves the development and deployment of a machine learning application designed to predict whether a student is placed based on three input features. The model is integrated with Railway through Docker, ensuring a streamlined deployment process. Below is a detailed workflow of the project:

### Workflow Description

1. **Data Preprocessing**

   - **Outlier Detection and Removal**: 
     Outliers were identified and removed using the Interquartile Range (IQR) method. This step is crucial to ensure that the model is trained on data that accurately represents the typical cases and avoids skewed predictions caused by extreme values.

   - **Feature Engineering and Dimensionality Reduction**:
     Feature engineering techniques were applied to create additional informative features. Principal Component Analysis (PCA) was employed to reduce the dimensionality of the dataset. PCA helps in transforming the features into a lower-dimensional space while preserving as much variance as possible, thus simplifying the model and enhancing its performance.

   - **Data Cleaning**:
     Unnecessary columns were removed to streamline the dataset, focusing on features relevant to the prediction task. Exploratory Data Analysis (EDA) was conducted to understand the dataset's characteristics, such as distributions, correlations, and patterns, which informed further preprocessing steps.

   - **Data Scaling**:
     The dataset was scaled to ensure that all features contribute equally to the model's learning process. Scaling is essential for algorithms like K-Nearest Neighbors (KNN) that are sensitive to the magnitudes of features.

2. **Model Development**

   - **K-Nearest Neighbors (KNN) Model**:
     A K-Nearest Neighbors algorithm was implemented to classify whether a student is placed based on the input features. KNN was chosen for its effectiveness in classification tasks due to its simplicity and ease of interpretation.

   - **Model Performance Evaluation**:
     The model's accuracy was evaluated and improved by 7% through the application of scaling and PCA. This enhancement demonstrates the importance of proper data preprocessing in achieving better model performance.

3. **Model Serialization and Deployment**

   - **Model Serialization**:
     The trained KNN model was serialized into a `.pkl` file. This file format allows for easy saving and loading of the model, facilitating its use in different environments without the need to retrain.

   - **Flask API Development**:
     A Flask application was developed to serve the model. The API facilitates interaction between the app and the model, enabling real-time predictions based on user inputs.

   - **Docker Containerization**:
     Docker was used to containerize the Flask application and the serialized model. Containerization ensures that the application runs consistently across various environments by encapsulating it along with its dependencies.

   - **Deployment on Railway**:
     The Dockerized Flask application was deployed on Railway, a platform that provides scalable hosting solutions. This deployment ensures that the application is accessible and reliable, supporting real-time prediction requests from users.

### Screenshots

Here are some screenshots of the application:

1. ![Login Screen](https://github.com/Volcann/Resume-Projects/blob/b014567b78d20f2bcf3121a3fc20e560507dd345/PlacementAnalyzer/Screenshot_3.png)

2. ![If the user passed and placed](https://github.com/Volcann/Resume-Projects/blob/b014567b78d20f2bcf3121a3fc20e560507dd345/PlacementAnalyzer/Screenshot_2.png)

3. ![If the user failed placements](https://github.com/Volcann/Resume-Projects/blob/b014567b78d20f2bcf3121a3fc20e560507dd345/PlacementAnalyzer/Screenshot_1.png)

### Conclusion

The Student Placement Prediction App effectively integrates data preprocessing, machine learning, and deployment practices. By following a structured workflow, including data cleaning, feature engineering, model training, and deployment, the application delivers accurate predictions and is easily accessible through a scalable cloud platform.

For more details about deployment, visit the GitHub repository: [Flask App](https://github.com/Volcann/Flask-App.git)
