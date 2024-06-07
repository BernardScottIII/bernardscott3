<script>
    export let data;
    const title = data.title;
    const description = data.description;
</script>

<main>
    <a class="back-button-container" href="/portfolio">
        <svg xmlns="http://www.w3.org/2000/svg" width="64" height="64" fill="green" class="bi bi-arrow-left back-button" viewBox="0 0 16 16">
            <path stroke="green" stroke-width="0.5px" fill-rule="evenodd" d="M15 8a.5.5 0 0 0-.5-.5H2.707l3.147-3.146a.5.5 0 1 0-.708-.708l-4 4a.5.5 0 0 0 0 .708l4 4a.5.5 0 0 0 .708-.708L2.707 8.5H14.5A.5.5 0 0 0 15 8"/>
            </svg>
    </a>
    <h1>Project details about {title}</h1>
    <p>{description}</p>
</main>