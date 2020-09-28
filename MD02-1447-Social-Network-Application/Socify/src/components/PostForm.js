import React from 'react';
import { useSelector } from 'react-redux';
import { Modal, Button } from 'react-bootstrap';
import { useFormik } from 'formik';
import { useDispatch } from 'react-redux';
import TextareaAutosize from 'react-textarea-autosize';
import { Link } from 'react-router-dom';
import styled from 'styled-components';
import { placeholder, generateMediaUrl } from '../utilities';
import PostFileUploadButton from './subcomponents/post/PostFileUploadButton';
import { createPost } from '../store/slices/posts';
import { Spinner } from 'react-bootstrap';
import { removeMedia } from '../store/slices/upload';

const Input = styled.input`
 margin-top: 1rem;

 &:hover{
     cursor: pointer;
 }
`;

const Img = styled.img`
display: inline-block;
text-align: center;
margin: 0px 20px 20px 0px;
width: 50px;
height: 50px;
`;


const Icon = styled.i`
 font-size: 20px;
 display: inline-block;
`;

const Text = styled.span`
display: block;
font-size: 0.8rem;
`;

const Section = styled.section`
padding: 1.25rem 0px !important;
padding-top: 0px;
padding-bottom: 0px;
margin: 0px !important;
`;

const Cardbox = styled.div`
border-radius: 3px;
margin-bottom: 20px;
padding: 0px !important;
`;

const IconButton = styled.button`
background: none;
color: #bbbbbb;
padding: 10px 10px;
cursor: pointer;
border: none;
outline:none;
display: inline-block;
transition: transform 0.2s;
position: absolute;
right: 1.3rem;
top: 1.4rem;

 &:focus{
    outline:0;
 }

 &:hover{
    transform: scale(1.2);
 }
`;

const CloseButton = styled.button`
background: none;
color: #bbbbbb;
padding: 10px 10px;
cursor: pointer;
border: none;
outline:none;
transition: transform 0.2s;
position: absolute;
z-index: 1;
right: 20px;

 &:focus{
    outline:0;
 }

 &:hover{
    transform: scale(1.2);
 }
`;

const PostForm = () => {
    const user = useSelector(state => state.auth.user);
    const [isOpen, setIsOpen] = React.useState(false);
    const isLoading = useSelector(state => state.upload.isLoading);
    const media = useSelector(state => state.upload.media);
    const dispatch = useDispatch();
    const handleClose = () => {
        setIsOpen(false);
    };

    const formik = useFormik({
        initialValues: {
            title: '',
            content: '',
            mediaId: null
        },

        onSubmit: (values) => {
            if (media) {
                values.mediaId = media.id;
            }
            dispatch(createPost(values));
            setIsOpen(false);
            values.mediaId = null;
        },

    });

    return (
        <Section>
            <Modal show={isOpen} onHide={handleClose}>
                <Modal.Header>
                    <Modal.Title style={{ margin: '0 auto' }}>Create Post</Modal.Title>
                </Modal.Header>
                <Modal.Body style={{ paddingBottom: 'none' }}>
                    <span className="float-left">
                        <Link to="/me"><Img className="rounded-circle" style={{ objectFit: 'cover' }} src={user.avatarId ? generateMediaUrl(user.avatarId) : placeholder} /></Link>
                    </span>
                    <h3 className="m-0">{user.name}</h3>
                    <Text className="float-left"></Text>
                    <form id="create-post-form" onSubmit={formik.handleSubmit}>
                        <TextareaAutosize name="content" className="form-control" style={{ border: 'none', resize: 'none', overflowY: 'hidden', marginBottom: '1rem' }} placeholder={`What's on your mind, ${user.name}`} onChange={formik.handleChange} onBlur={formik.handleBlur}></TextareaAutosize>
                        <div className="d-flex justify-content-center">
                            <Spinner hidden={!isLoading} animation="border" role="status">
                                <span className="sr-only">Loading...</span>
                            </Spinner>
                        </div>
                        {media &&
                            <>
                                <img className="img-fluid w-100" src={generateMediaUrl(media.id)} alt="Post Content" />
                                <CloseButton onClick={() => dispatch(removeMedia())}><Icon className="fa fa-times"></Icon></CloseButton>
                            </>
                        }
                        <PostFileUploadButton name="media" className="btn w-100" />
                    </form>
                </Modal.Body>
                <Modal.Footer>
                    <Button type='submit' form="create-post-form" className={`w-100 btn-dark ${isLoading ? 'disabled' : ''}`}>Publish</Button>
                </Modal.Footer>
            </Modal >
            <div className="container">
                <div className="row">
                    <div className="col-lg-6 offset-lg-3">
                        <Cardbox className="shadow-lg bg-white" style={{ borderRadius: '2rem' }}>
                            <div className="media m-0">
                                <div className="d-flex mr-0">
                                    <a href="#AuthorProfile"><img className="rounded-circle" style={{ objectFit: 'cover', margin: '0.5rem' }} src={user.avatarId ? generateMediaUrl(user.avatarId) : placeholder} alt="User" /></a>
                                </div>
                                <div className="media-body">
                                    <Input className="form-control" placeholder="What's on your mind?" onClick={(e) => setIsOpen(true)} />
                                    <IconButton><Icon className="fa fa-camera"></Icon></IconButton>
                                </div>
                            </div>
                        </Cardbox>
                    </div>
                </div>
            </div>
        </Section >
    )
}

export default PostForm;