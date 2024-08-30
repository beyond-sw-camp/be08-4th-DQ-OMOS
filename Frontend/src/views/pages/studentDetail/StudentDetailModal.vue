<template>
    <Dialog :visible="visible" header="학생 상세 정보" :modal="true" :closable="true" @hide="onHide">
        <div v-if="student">
            <p><strong>이름:</strong> {{ student.name }}</p>
            <p><strong>개강일:</strong> {{ formatDate(student.date) }}</p>
            <p><strong>상태:</strong> {{ student.status }}</p>
        </div>
    </Dialog>
</template>

<script setup>

const props = defineProps({
    student: Object,
    visible: Boolean
});

const emit = defineEmits(['update:visible']);

function onHide() {
    emit('update:visible', false);
}

function formatDate(value) {
    return value.toLocaleDateString('en-US', {
        day: '2-digit',
        month: '2-digit',
        year: 'numeric'
    });
}
</script>
