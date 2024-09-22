# ComposeImageFilter


| ![KakaoTalk_Photo_2024-09-22-11-44-27 005](https://github.com/user-attachments/assets/5e1edee9-32ff-41a3-a41a-12b6f18e07f7)     |  ![KakaoTalk_Photo_2024-09-22-11-44-27 004](https://github.com/user-attachments/assets/b525ea91-cced-4818-ab29-a1725a42225d)    |   ![KakaoTalk_Photo_2024-09-22-11-44-26 003](https://github.com/user-attachments/assets/e3936d2a-f3c1-4777-8635-17134e1e3200)   |  ![KakaoTalk_Photo_2024-09-22-11-44-26 002](https://github.com/user-attachments/assets/b6e5c44c-ea6e-40f3-87dc-8ab75838a83d)    |   ![KakaoTalk_Photo_2024-09-22-11-44-26 001](https://github.com/user-attachments/assets/958815f0-5fce-4bb9-ba8d-67e636c85d60)   |
| ---- | ---- | ---- | ---- | ---- |

**적용된 필터 목록**

GPU Image Filter

### 1. **Normal**

- `GPUImageFilter()`
- 이 필터는 아무런 변환을 하지 않는 기본 필터로, 원래 이미지의 색상 값이 그대로 유지됩니다.

### 2. **Retro**

```
kotlin


코드 복사
floatArrayOf(
    1.0f, 0.0f, 0.0f, 0.0f,
    0.0f, 1.0f, 0.2f, 0.0f,
    0.1f, 0.1f, 1.0f, 0.0f,
    1.0f, 0.0f, 0.0f, 1.0f
)
```

- 이 필터는 고전적인 색상 표현을 위해 빨간색, 파란색 계열의 색을 강조하고 녹색 계열을 약간 줄였습니다. 특히 세 번째 열에서 파란색 채널이 약간 더 두드러지게 만들어, 오래된 사진처럼 보이도록 조정합니다.

### 3. **Just**

```
kotlin


코드 복사
floatArrayOf(
    0.4f, 0.6f, 0.5f, 0.0f,
    0.0f, 0.4f, 1.0f, 0.0f,
    0.05f, 0.1f, 0.4f, 0.4f,
    1.0f, 1.0f, 1.0f, 1.0f
)
```

- 이 필터는 주로 녹색과 청색 채널을 강조하며, 붉은색 채널을 약화시킵니다. 그 결과 차분하면서도 살짝 차가운 색조를 만들어냅니다.

### 4. **Hume**

```
kotlin


코드 복사
floatArrayOf(
    1.25f, 0.0f, 0.2f, 0.0f,
    0.0f, 1.0f, 0.2f, 0.0f,
    0.0f, 0.3f, 1.0f, 0.3f,
    0.0f, 0.0f, 0.0f, 1.0f
)
```

- 붉은색 채널을 약간 강조하여 따뜻한 톤을 만들어내며, 녹색과 파란색에도 미묘한 변화가 있어 전체적인 이미지에 따뜻한 느낌을 줍니다.

### 5. **Desert**

```
kotlin


코드 복사
floatArrayOf(
    0.6f, 0.4f, 0.2f, 0.05f,
    0.0f, 0.8f, 0.3f, 0.05f,
    0.3f, 0.3f, 0.5f, 0.08f,
    0.0f, 0.0f, 0.0f, 1.0f
)
```

- 사막의 따뜻한 색감을 표현하기 위해 전체적으로 노란색과 붉은색 계열이 강화되었습니다. 이 필터는 붉은색과 노란색을 강조하여 건조하고 따뜻한 느낌을 줍니다.

### 6. **Old Times**

```
kotlin


코드 복사
floatArrayOf(
    1.0f, 0.05f, 0.0f, 0.0f,
    -0.2f, 1.1f, -0.2f, 0.11f,
    0.2f, 0.0f, 1.0f, 0.0f,
    0.0f, 0.0f, 0.0f, 1.0f
)
```

- 오래된 사진처럼 붉은색과 파란색이 강조되고, 녹색이 약간 억제되었습니다. 이 필터는 세피아톤과 비슷한 느낌을 줍니다.

### 7. **Limo**

```
kotlin


코드 복사
floatArrayOf(
    1.0f, 0.0f, 0.08f, 0.0f,
    0.4f, 1.0f, 0.0f, 0.0f,
    0.0f, 0.0f, 1.0f, 0.1f,
    0.0f, 0.0f, 0.0f, 1.0f
)
```

- 이 필터는 파란색과 약간의 녹색을 강화하여 청록색 느낌을 줍니다. `0.08f`처럼 작은 값이 파란색과 조화된 독특한 색감을 만듭니다.

### 8. **Sepia**

- `GPUImageSepiaToneFilter()`
- 세피아 필터는 사진을 갈색 톤으로 변환하여 고전적인 느낌을 줍니다. 세피아는 고전적이면서 따뜻한 분위기를 연출하는 데 자주 사용됩니다.

### 9. **Solar**

```
kotlin


코드 복사
floatArrayOf(
    1.5f, 0f, 0f, 0f,
    0f, 1f, 0f, 0f,
    0f, 0f, 1f, 0f,
    0f, 0f, 0f, 1f
)
```

- 이 필터는 빨간색 채널을 강하게 강조하여 강한 태양광이나 조명 아래서의 효과처럼 보이도록 합니다.

### 10. **Wole**

- `GPUImageSaturationFilter(2.0f)`
- 이 필터는 채도를 증가시켜 이미지의 색감을 더 진하고 선명하게 만들어줍니다.

### 11. **Neutron**

```
kotlin


코드 복사
floatArrayOf(
    0f, 1f, 0f, 0f,
    0f, 1f, 0f, 0f,
    0f, 0.6f, 1f, 0f,
    0f, 0f, 0f, 1f
)
```

- 녹색 채널이 강조되면서 중성적인 색감을 표현합니다. 이 필터는 자연스러운 색상 조정을 통해 중립적인 색감을 만듭니다.

### 12. **Bright**

- `GPUImageRGBFilter(1.1f, 1.3f, 1.6f)`
- RGB 채널에서 밝기를 높이는 필터입니다. 특히 파란색 채널을 더 강하게 밝히면서 시원한 느낌을 줍니다.

### 13. **Milk**

```
kotlin


코드 복사
floatArrayOf(
    0.0f, 1.0f, 0.0f, 0.0f,
    0.0f, 1.0f, 0.0f, 0.0f,
    0.0f, 0.64f, 0.5f, 0.0f,
    0.0f, 0.0f, 0.0f, 1.0f
)
```

- 파란색을 약간 줄이고, 녹색을 강조하여 부드러운 색조를 만들어내며, 이미지가 우유처럼 부드럽고 연한 느낌이 들도록 합니다.

### 14. **BW (Black & White)**

```
kotlin


코드 복사
floatArrayOf(
    0.0f, 1.0f, 0.0f, 0.0f,
    0.0f, 1.0f, 0.0f, 0.0f,
    0.0f, 1.0f, 0.0f, 0.0f,
    0.0f, 1.0f, 0.0f, 1.0f
)
```

- 이미지의 색상을 단색으로 변환하는 흑백 필터입니다.
