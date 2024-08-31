<template>
    <Dialog :visible.sync="localVisible" header="학생 상세 정보" :modal="true" :closable="true" @update:visible="handleVisibilityUpdate">
        <div v-if="student">
            <p><strong>이름:</strong> {{ student.name }}</p>
            <p><strong>개강일:</strong> {{ formatDate(student.date) }}</p>
            <p><strong>상태:</strong> {{ student.status }}</p>
        </div>
    </Dialog>
</template>

<script setup>
import { ref, watch } from 'vue';

const props = defineProps({
    student: Object,
    visible: Boolean
});

const emit = defineEmits(['update:visible']);

const localVisible = ref(props.visible);

// 부모에서 받은 visible 상태를 로컬 상태로 반영
watch(
    () => props.visible,
    (newVal) => {
        localVisible.value = newVal;
    }
);

// 로컬 visible 상태가 변경되면 부모 컴포넌트에 반영
function handleVisibilityUpdate(newVal) {
    localVisible.value = newVal;
    emit('update:visible', newVal);
}

function formatDate(value) {
    return value.toLocaleDateString('en-US', {
        day: '2-digit',
        month: '2-digit',
        year: 'numeric'
    });
}
</script>
