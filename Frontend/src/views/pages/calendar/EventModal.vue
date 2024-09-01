<template>
    <div class="modal-overlay" v-if="isOpen">
        <div class="modal-container">
            <h3 class="modal-title">이벤트 생성</h3>
            <form @submit.prevent="submitForm">
                <div>
                    <label for="title">이벤트 이름:</label>
                    <input type="text" v-model="eventData.title" id="title" required />
                </div>
                <div>
                    <label for="start">시작 날짜 및 시간:</label>
                    <input type="datetime-local" v-model="eventData.start" id="start" required />
                </div>
                <div>
                    <label for="end">종료 날짜 및 시간:</label>
                    <input type="datetime-local" v-model="eventData.end" id="end" />
                </div>
                <div>
                    <label for="category">카테고리:</label>
                    <select v-model="eventData.category" id="category" required>
                        <option value="휴가">휴가</option>
                        <option value="출근">출근</option>
                        <option value="병가">병가</option>
                        <option value="조퇴">조퇴</option>
                    </select>
                </div>
                <div class="modal-actions">
                    <button type="submit">저장</button>
                    <button type="button" @click="closeModal">취소</button>
                </div>
            </form>
        </div>
    </div>
</template>

<script>
export default {
    props: {
        isOpen: Boolean,
        initialData: Object
    },
    data() {
        return {
            eventData: {
                title: '',
                start: '',
                end: '',
                category: '출근'
            }
        };
    },
    watch: {
        initialData(newData) {
            if (newData) {
                this.eventData = { ...newData };
            }
        }
    },
    methods: {
        closeModal() {
            this.$emit('close');
        },
        submitForm() {
            this.$emit('save', this.eventData);
            this.closeModal();
        }
    }
};
</script>

<style scoped>
.modal-overlay {
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background-color: rgba(0, 0, 0, 0.5);
    display: flex;
    justify-content: center;
    align-items: center;
    z-index: 1000;
}

.modal-container {
    background: white;
    padding: 2em;
    border-radius: 5px;
    width: 300px;
}

.modal-title {
    text-align: center;
    font-size: 1.5em;
    margin-bottom: 1em;
}

.modal-actions {
    display: flex;
    justify-content: space-between;
    margin-top: 1em;
}

button {
    padding: 0.5em 1em;
    border: none;
    background-color: #007bff;
    color: white;
    cursor: pointer;
    border-radius: 4px;
}

button:last-child {
    background-color: #ddd;
    color: black;
}
</style>
